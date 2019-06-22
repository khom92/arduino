//Arduino - Decimal a Binario
//Código:
//By Daniel OM.

int LEDP[] = {2, 3, 4, 5, 6, 7, 8, 9};
float num;
int num2;

void setup() {
  for (int i = 0; i < 8; i++) {
    pinMode(LEDP[i], OUTPUT);
  }
  Serial.begin(9600);
}

void loop() {
  for (int i = 0; i < 8; i++) {
    digitalWrite(LEDP[i], LOW);
  }
  Serial.println("Ingrese decimal (0-99)");
  while (Serial.available() == 0) {}
    num = Serial.parseFloat(); 
  String num3 = String(num); 
    int primer = int(num3.charAt(0))- '0';
    int segun = int(num3.charAt(1))- '0';
  if (int(num) == num && num <= 99) //si es entero y es menor a 99 hacer
  {
    if (primer >= 0 && primer <= 9) {
      for (int i = 0; i < 4; i++) {
        if (primer % 2 == 1) { 
          digitalWrite(LEDP[i], HIGH);
        }
        else { 
          digitalWrite(LEDP[i], LOW);
        }
          primer = primer / 2;
        }
   } 
    if (segun >= 0 && segun <= 9) {
      for (int j = 4; j < 8; j++) {
        if (segun % 2 == 1) { 
          digitalWrite(LEDP[j], HIGH);
        }
        else { 
          digitalWrite(LEDP[j], LOW);

          }
        segun = segun / 2;
        }
    }
  }
  else {
    Serial.println("Error; El numero ingresado no es valido");
  }
  delay(1000);
}
