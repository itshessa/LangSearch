from flask import Flask, jsonify, request
import json
from Predict import Predict
app = Flask(__name__)
@app.route('/predict', methods=['POST'])
def start():
    d1 = request.get_json()
    json_ = json.dumps(d1)
    p = Predict(json_)
    results=p.run(json_)
    return jsonify(results)
if __name__ == "__main__":
    app.run(debug=True)