
import requests
import json
import hashlib

def cifra_cesar(passo, texto):
    decifrado = ''
    for letra in texto:
        if letra.isalpha():
            ordem = ord(letra)
            decifrado += chr(((ordem-96 + passo) % 26) + 96)
        else:
            decifrado += letra
    
    return decifrado

r = requests.get('https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=79d27d9493938a44e3eab305ebccdcdb661df3d9')

with open('answer', 'w') as f:
    json.dump(r.json(), f)
    
with open('answer', 'r') as f:
    datastore = json.load(f)

decifrado = cifra_cesar(datastore["numero_casas"], datastore["cifrado"])

datastore["decifrado"] = decifrado
datastore["resumo_criptografico"]= hashlib.sha1(decifrado.encode()).hexdigest()

with open('answer', 'w') as f:
    json.dump(datastore, f)

with open('answer','r') as f:
    r = requests.post('https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=79d27d9493938a44e3eab305ebccdcdb661df3d9', files ={'answer': f})
print(r.text)