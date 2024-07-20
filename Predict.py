import json
import csv
import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler
import pysolr
import pickle
from SolrClient import SolrClient
import nltk
from nltk.corpus import wordnet as wn
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from nltk.tokenize import word_tokenize
from nltk import pos_tag
from string import punctuation
from collections import defaultdict
from sklearn.feature_extraction.text import CountVectorizer
    
class Predict:
    data = {}
    def __init__(self, req_data):
        self.data = req_data
        
    def run(self, data):
        self.create_csv_file(data)
        result = self.run_model()
        final_result = self.get_final_result(result)        
        return  final_result

    def create_csv_file(self, req_data):
        data =json.loads(req_data)
        results=data['metadataResultList']
        data_file = open('data/data.csv', 'w')
        csv_writer = csv.writer(data_file)
        count = 0
        for flow in results:
            if count == 0:
                header = flow.keys()
                csv_writer.writerow(header)
                count += 1
            csv_writer.writerow(flow.values())
        data_file.close()


    def get_final_result(self, result_file):
        solr = pysolr.Solr('https://ss900697-vw5yg8u1-ap-south-1-aws.searchstax.com/solr/LangSearchDocs_shard1_replica_n1', always_commit=True)
        df = pd.read_csv('data/Model_result.csv')
        results_list= []
        for row in df.itertuples():
            if row.targeted != "NONE":
                result = {
                    'title': row.title,
                    'snippet': row.snippet,
                    'id': row.link,
                    'targeted': row.targeted,
                    'skill': row.skill,
                    'level': row.level,
                    }
                results_list.append(result)
        solr.add(results_list)
        return results_list
    
    
    def run_model(self):
        user_data = pd.read_csv('data/data.csv')
        df=user_data[['title', 'snippet']]
        df['text']=df['title']+df['snippet'].values.astype(str)
       
        #predicting the targeted language 
        pkl_targeted = "targeted_model.pkl"
        targeted_model = pickle.load(open(pkl_targeted, 'rb'))
        predict_targeted = targeted_model.predict(df.text.astype(str))    
        predictn_targeted = predict_targeted.tolist()
        predicted_df_targeted = pd.DataFrame(data=predictn_targeted, columns=['targeted'])
        targeted_df = pd.merge(user_data, predicted_df_targeted, how ='left', left_index=True,right_index=True)
        result_file1 = pd.merge(user_data, predicted_df_targeted, how ='left', left_index=True,right_index=True)
        #predicting the skill
        targeted_df['text'] = targeted_df['title']+targeted_df['snippet'].values.astype(str)+targeted_df['targeted']
        pkl_skill = "skill_model.pkl"
        skill_model = pickle.load(open(pkl_skill, 'rb'))
        predict_skill = skill_model.predict(targeted_df.text.astype(str))
        Predictn_skill = predict_skill.tolist()
        predict_df_skill = pd.DataFrame(data=Predictn_skill, columns=['skill'])
        skill_df = pd.merge(targeted_df, predict_df_skill, how ='left', left_index=True,right_index=True)
        result_file2 = pd.merge(result_file1, predict_df_skill, how ='left', left_index=True,right_index=True)
        #predicting the level
        skill_df['text'] = skill_df['title']+skill_df['snippet'].values.astype(str)+skill_df['targeted']+skill_df['skill']
        pkl_level = "level_model.pkl"
        level_model = pickle.load(open(pkl_level, 'rb'))
        predict_level = level_model.predict(skill_df.text.astype(str))
        Predictn_level = predict_level.tolist()
        predict_df_level = pd.DataFrame(data=Predictn_level, columns=['level'])
        result_file = pd.merge(result_file2, predict_df_level, how ='left', left_index=True,right_index=True)
        result_file.to_csv('data/Model_result.csv')
        return result_file

