* Addresses:
DELETE: http://clinicat.tk/addresses/1
PUT: http://clinicat.tk/addresses
Body: {"id": 1,"streetAddress": "1993 Preston Street","city": "Caney","state": "KS","postalCode": "67343"}

POST: http://clinicat.tk/addresses
Body: {"streetAddress": "3632 Preston Street","city": "Caney","state": "KS","postalCode": "67333"}

GET: http://clinicat.tk/addresses/1
GET: http://clinicat.tk/addresses

* Diseases:
DELETE: http://clinicat.tk/diseases/1
PUT: http://clinicat.tk/diseases
Body: {"id": 1, "icd": { "diseaseCode": "A00.9" }, "prescription": { "id": 1 }}

POST: http://clinicat.tk/diseases
Body: { "icd": { "diseaseCode": "A00.1" }}

GET: http://clinicat.tk/diseases/1
GET: http://clinicat.tk/diseases

* Drugs:
DELETE: http://clinicat.tk/drugs/1
PUT: http://clinicat.tk/drugs
Body: {"id": 1, "medicine": { "name": "Dexmedetomidin" }, "prescription": { "id": 1 }}

POST: http://clinicat.tk/drugs
Body: { "medicine": { "name": "Dexmedetomidin" }}

GET: http://clinicat.tk/drugs/1
GET: http://clinicat.tk/drugs

* Patients:
DELETE: http://clinicat.tk/patients/1
PUT: http://clinicat.tk/patients
Body: {"name": "Brendan D. Michael","gender": "male","birthday": "13/05/1999","address": {"id": 1}}

POST: http://clinicat.tk/patients
Body: {"name": "Brendan D. Michael","gender": "male","birthday": "29/11/1964","address": {"id": 1}}

GET: http://clinicat.tk/patients/1
GET: http://clinicat.tk/patients
GET: http://clinicat.tk/patients?id=1
GET: http://clinicat.tk/patients?name=Brendan D. Michael
GET: http://clinicat.tk/patients?birthday=29/11/1964

* Prescriptions:
DELETE: http://clinicat.tk/prescriptions/1
PUT: http://clinicat.tk/prescriptions
Body: { "id": 1, "quantity": 1, "dose": "3 meals per day", "howToUse": "nothing"}

POST: http://clinicat.tk/prescriptions
Body: {"quantity": 2,"dose": "2 meals per day","howToUse": "cool on today","drugs": [{"medicine": {"name": "Diazepam"}},{"medicine": {"name": "Etomidat"}}],"diseases": [{"icd": {"diseaseCode": "A00.1"}},{"icd": {"diseaseCode": "A01.3"}}]}

GET: http://clinicat.tk/prescriptions/1
GET: http://clinicat.tk/prescriptions
GET: http://clinicat.tk/prescriptions/1/drugs
GET: http://clinicat.tk/prescriptions/1/diseases

* Reports:
GET: http://clinicat.tk/reports/number-of-patient-visit-per-day
GET: http://clinicat.tk/reports/number-of-drug-used-per-day

* Visits:
DELETE: http://clinicat.tk/visits/1
PUT: http://clinicat.tk/visits
Body: {"id": 1,"date": "23/07/2018","time": "09:10:69","problems": "headache","prescription": {"id": 1},"patient": {"id": 1}}

POST: http://clinicat.tk/visits
Body: {"date": "24/07/2018","time": "09:10:69","problems": ["headache","stomache"],"prescription": {"id": 1},"patient": {"id": 1}}

GET: http://clinicat.tk/visits/1
GET: http://clinicat.tk/visits
GET: http://clinicat.tk/visits?date=24/07/2018
GET: http://clinicat.tk/visits?patientId=1
