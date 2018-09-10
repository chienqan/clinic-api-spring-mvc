Cloud Server:
-DNS: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080
-IP: 18.191.187.195:8080

1. PATIENT:
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/patients
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/patients/1         //get patient by id
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/patientsByName?name=Linh       //get patient by name
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/patientsByBirthdate?birthdate=3-10-2000        //get patient by birthdate
    -DELETE: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/patients/1
    -POST: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/patients
    Body:   {
                    "name": "Nguyen Van Minh",
                    "birthdate": "2-4-1990",
                    "gender": "M",
                    "address": "20 Nguyen Trai"
            }

    -PUT: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/patients
    Body:   {
                    "id": 2
                    "name": "Nguyen Cong Minh",
                    "birthdate": "1-6-1990",
                    "gender": "M",
                    "address": "20 Nguyen Trai"
             }

2. VISIT:
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visits
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visits/1
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visits/patient/1               //get visits by patient
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visitsByDate?date=20-10        //get visits by date
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visitsPerDay               //get report of number of visits per day
    -DELETE: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visits/1
    -POST: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visits
    Body:   {
            	"patient":{
            		"id":1
            	},
            	"problems":"headache, indigestion",
            	"visitTime":"20-02-2018"
            }

    -PUT: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/visits
    Body:   {
                "id":2,
                "patient":{
                    "id":1
                },
                "problems":"paranoid",
                "visitTime":"02-06-2014"
             }

3. PRESCRIPTION:
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptions
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptions/1
    -DELETE: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptions/1
    -POST: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptions          //can have at most 1 prescription per visit
    Body:     {
                  "visit":{
                  	"id":2
                  }
              }

    -PUT: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptions
    Body:     {
                  "id":2
                  "visit":{
                     "id":3
                  }
               }

4. PRESCRIPTION DETAIL:
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptionDetails
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptionDetails/1
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/details/prescription/1    //get details of a prescription
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/drugPrescribed            //get report of number of drugs prescribed
    -DELETE: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptionDetails/1
    -POST: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptionDetails
    Body:{
             "prescription": {
                 "id":2
             },
             "drug": {
                 "id": 80
             },
             "quantity": 20,
             "dose": "50mg",
             "instruction": "3 times per day after meal"
         }

    -PUT: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/prescriptionDetails
    Body:{
             "id":1,
             "prescription": {
                 "id":2
             },
             "drug": {
                 "id": 40
             },
             "quantity": 20,
             "dose": "50mg",
             "instruction": "5 times per day"
         }

5. DIAGNOSIS
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/diagnosis
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/diagnosis/1
    -GET: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/diagnosis/visit/1      //get diagnosis by visit
    -DELETE: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/diagnosis/1
    -POST: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/diagnosis
    Body: {
          	"visit":{
          		"id":1
          	},
          	"disease":{
          		"icd":"A00.1"
          	}
          }

    -PUT: ec2-18-191-187-195.us-east-2.compute.amazonaws.com:8080/diagnosis
    Body: {
            "id":1,
          	"visit":{
          		"id":2
          	},
          	"disease":{
          		"icd":"A00.2"
          	}
          }
