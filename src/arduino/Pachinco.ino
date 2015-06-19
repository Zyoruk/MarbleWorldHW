#include <Servo.h>

//Servo PIN
Servo window;  // create servo object to control a servo 
Servo gate;  // create servo object to control a servo 

//Servo1 Positions
const int A = 0;//Shared
const int B = 6.33431085;
const int C = 12.668621701;
const int D = 19.002932551;
const int E = 25.337243402;
const int F = 31.671554252;//Shared

//Servo0 Positions
const int Y = 15.835777126;

//Previous positions
int last01 = 0;
int last02 = 0;

//Input
String gateLetter = "";   // a string to hold incoming data
String time = "";         // a string to hold incoming data
long timetoMove = -1;
boolean stringComplete = false;  // whether the string is complete

//State
int state = 0;
String c;

void setup() {
  Serial.begin(115200);
  window.attach(5);  // attaches the servo on pin 9 to the servo object 
  gate.attach(3);  // attaches the servo on pin 9 to the servo object
  gateLetter.reserve(10); 
  //pinMode(LED, OUTPUT);    //tell Arduino LED is an output
  //pinMode(BUTTON, INPUT);  //BUTTON is an input
  //pinMode(speakerPin, OUTPUT);    //and BUZ is an output
}

void serialEvent() {
  while (Serial.available()) {
    // get the new byte:
    char inChar = (char)Serial.read();
    c = String(inChar);
    if(c == ","){
        state = 1;
    }else{
      if(state == 0){
        getValue();
        gateLetter += inChar;
      }else{
        time += inChar;
      }
      if (inChar == '\n') {
        timetoMove = time.toInt();
        stringComplete = true;
      }
    }     
  }
}

void getValue(){
  if(gateLetter == "A"){
    last01 = A;
  }
  if(gateLetter == "B"){
    last01 = B;
  }
  if(gateLetter == "C"){
    last01 = C;
  }
  if(gateLetter == "D"){
    last01 = D;
  }
  if(gateLetter == "E"){
    last01 = E;
  }
  if(gateLetter == "F"){
    last01 = F;
  }
  if(gateLetter == "X"){
    last02 = A;
  }
  if(gateLetter == "Y"){
    last02 = Y;
  }
  if(gateLetter == "Z"){
    last02 = F;
  }
}

void loop(){
  if (stringComplete) { 
    if( timetoMove == 0){  
      if( gateLetter == "X" || "Y" || "Z"){
    if(gateLetter == "X" ){
      window.write(A);
      delay(15);
    }
    if(gateLetter == "Y" ){
      window.write(Y); 
      delay(15);
    }
    if(gateLetter == "Z" ){
      window.write(F); 
      delay(15);
    }    
      }else{
    if(gateLetter == "A" ){
      gate.write(A); 
      delay(15);
    }
    if(gateLetter == "B" ){
      gate.write(B); 
      delay(15);
    }
    if(gateLetter == "C" ){
      gate.write(C); 
      delay(15);
    }
    if(gateLetter == "D" ){
      gate.write(D); 
      delay(15);
    }
    if(gateLetter == "E" ){
      gate.write(E); 
      delay(15);
    }
    if(gateLetter == "F" ){
      gate.write(F); 
      delay(15);
    }
      }  
    }else{
      if( gateLetter == "X" || "Y" || "Z" ){
        if(gateLetter == "X" ){
          window.write(A);
          delay(15+timetoMove);
          window.write(last01);
          delay(15);
        }
        if(gateLetter == "Y" ){
          window.write(Y);
          delay(15+timetoMove);
          window.write(last01);
          delay(15);
        }
        if(gateLetter == "Z" ){
          window.write(F); 
          delay(15+timetoMove);
          window.write(last01);
          delay(15);
        }
      }else{
        if(gateLetter == "A" ){
          gate.write(A); 
          delay(15+timetoMove);
          window.write(last02);
          delay(15);
        }
        if(gateLetter == "B" ){
          gate.write(B); 
          delay(15+timetoMove);
          window.write(last02);
          delay(15);
        }
        if(gateLetter == "C" ){
          gate.write(C); 
          delay(15+timetoMove);
          window.write(last02);
          delay(15);
        }
        if(gateLetter == "D" ){
          gate.write(D); 
          delay(15+timetoMove);
          window.write(last02);
          delay(15);
        }
        if(gateLetter == "E" ){
          gate.write(E); 
          delay(15+timetoMove);
          window.write(last02);
          delay(15);
        }
        if(gateLetter == "F" ){
          gate.write(F); 
          delay(15+timetoMove);
          window.write(last02);
          delay(15);
        }
      }
    }    
  stringComplete = false;    
  }
}
