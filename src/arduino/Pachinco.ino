#include <Servo.h>

//Servo PIN
Servo servo01;  // create servo object to control a servo 
Servo servo02;  // create servo object to control a servo 

//Input
char c = 'A';
String time = "";         // a string to hold incoming data
long timetoMove = -1;
boolean stringComplete = false;  // whether the string is complete

//State
int state = 0;
char curr1 = 'X';
char curr2 = 'A';
int movSix = 90;
int mov90 = 148;
String s;

void setup() {
  Serial.begin(9600);
  servo01.attach(9);  // attaches the servo on pin 9 to the servo object 
  servo02.attach(10);  // attaches the servo on pin 9 to the servo object
  time.reserve(10);
   
  //pinMode(LED, OUTPUT);    //tell Arduino LED is an output
  //pinMode(BUTTON, INPUT);  //BUTTON is an input
  //pinMode(speakerPin, OUTPUT);    //and BUZ is an output
}

void loop(){
  if (stringComplete) {
    Serial.println(c);
    Serial.println(time);

    switch(c){
      case 'C':
        c = 'A';
        break;
      case 'D':
        c = 'B';
        break;
      case 'E':
        c = 'A';
        break;
      case 'F':
        c = 'B';
        break;
    }    
     
    if( timetoMove == 0){
    
      switch(c){
        
        case 'A':
          if(curr2 == 'B' ){
              curr2 = 'A';
              servo02.write(movSix); 
              delay(700);
          }
          break;
        case 'B':
          if(curr2 == 'A' ){
              curr2 = 'B';
              servo02.write(-1 * movSix); 
              delay(700);
          }          
          break;
        
        case 'X':
          if(curr1 == 'Y' ){
              curr1 = 'X';
              servo01.write(-1 * mov90); 
              delay(700);
          }
          if(curr1 == 'Z' ){
              curr1 = 'X';
              servo01.write(-1 * mov90);
              delay(700);
          }
          break;
        case 'Y':
          if(curr1 == 'Z' ){
              curr1 = 'Y';
              servo01.write(-1 * mov90); 
              delay(700);
          } 
          if(curr1 == 'X' ){
              curr1 = 'Y';
              servo01.write(mov90); 
              delay(700);
          }         
          break;
        case 'Z':
          if(curr1 == 'Y' ){
              curr1 = 'Z';
              servo01.write(-1 * mov90); 
              delay(700);
          }
          if(curr1 == 'Y' ){
              curr1 = 'Z';
              servo01.write(-1 * mov90); 
              delay(700);
          }
          break;
      }
              
    }else{
      switch(c){
        
        case 'A':
          if(curr2 == 'B' ){
              curr2 = 'A';
              servo02.write(-1 * movSix); 
              delay(700+timetoMove);
              servo02.write(movSix); 
              delay(700);
          }
          break;
        case 'B':
          if(curr2 == 'A' ){
              curr2 = 'B';
              servo02.write(movSix);
              delay(700+timetoMove);
              servo02.write(-1 * movSix); 
              delay(700);
          }          
          break;
        
        case 'X':
          if(curr1 == 'Y' ){
              curr1 = 'X';
              servo01.write(-1 * movSix);
              delay(700+timetoMove);
              servo01.write(movSix); 
              delay(700);
          }
          if(curr1 == 'Z' ){
              curr1 = 'X';
              servo01.write(-1 * movSix);
              delay(700+timetoMove);
              servo01.write(movSix); 
              delay(700);
          }
          break;
        case 'Y':
          if(curr1 == 'Z' ){
              curr1 = 'Y';
              servo01.write(-1 * movSix);
              delay(700+timetoMove);
              servo01.write(movSix); 
              delay(700);
          } 
          if(curr1 == 'X' ){
              curr1 = 'Y';
              servo01.write(movSix);
              delay(700+timetoMove);
              servo01.write(-1 * movSix); 
              delay(700);
          }         
          break;
        case 'Z':
          if(curr1 == 'Y' ){
              curr1 = 'Z';
              servo01.write(-1 * movSix);
              delay(700+timetoMove);
              servo01.write(movSix);
              delay(700);
          }
          if(curr1 == 'Y' ){
              curr1 = 'Z';
              servo01.write(-1 * movSix); 
              delay(700+timetoMove);
              servo01.write(movSix); 
              delay(700);
          }
          break;
      }
    }
    stringComplete = false;
    state = 0;
    time = "";
  }
}

void serialEvent() {
  while (Serial.available()) {
    // get the new byte:
    char inChar = (char)Serial.read();
    s = String(inChar);
    if(s == ","){
        state = 1;
    }else{
      if(state == 0){
        c = inChar;
      }else{
        time += inChar;
      }
      if (inChar == '\n') {
        timetoMove = time.toInt();
        stringComplete = true;
        s = "";
      }
    }     
  }
}

