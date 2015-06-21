#include <Servo.h>

//Servo PIN
Servo servo01;  // create servo object to control a servo 
Servo servo02;  // create servo object to control a servo 

//Input
String servoNum = "";   // a string to hold incoming data
String time = "";         // a string to hold incoming data
long timetoMove = -1;
boolean stringComplete = false;  // whether the string is complete

//State
int state = 0;
String curr1 = "X";
String curr2 = "ACE";
int movSix = 90;
int mov90 = 148;
String c;

void setup() {
  Serial.begin(9600);
  servo01.attach(5);  // attaches the servo on pin 9 to the servo object 
  servo01.attach(3);  // attaches the servo on pin 9 to the servo object
  servoNum.reserve(10); 
  //pinMode(LED, OUTPUT);    //tell Arduino LED is an output
  //pinMode(BUTTON, INPUT);  //BUTTON is an input
  //pinMode(speakerPin, OUTPUT);    //and BUZ is an output
}

void loop(){
  if (stringComplete) {
    Serial.println(servoNum);
    Serial.println(time);
    if(servoNum == "A"){
      servoNum = "ACE";
    }
    
    if(servoNum == "C"){
      servoNum = "ACE";
    }
    
    if(servoNum == "E"){
      servoNum = "ACE";
    }
    
    if(servoNum == "B"){
      servoNum = "BDF";      
    }
    
    if(servoNum == "D"){
      servoNum = "BDF";      
    }
    
    if(servoNum == "F"){
      servoNum = "BDF";      
    }
    
    Serial.println(servoNum);
    
    if( timetoMove == 0){  
      
      if( servoNum == "X" || "Y" || "Z"){ //CHANGE
        
        if(curr1 == "Y" ){
          if(servoNum == "X"){
            curr1 = "X";
            servo01.write(-1 * mov90);
            delay(700);
          }
          
          if(servoNum == "Z"){
            curr1 = "Z";
            servo01.write(mov90); 
            delay(700);
          }  
        }
        
        if(curr1 == "X"){
          if(servoNum == "Y"){
            curr1 = "Y";
            servo01.write(mov90);
            delay(700);
          }
          
          if(servoNum == "Z"){
            curr1 = "Z";
            servo01.write(mov90);
            delay(700);
            servo01.write(mov90);
            delay(700);
          }  
        }
        
        if(curr1 == "Z"){
          if(servoNum == "Y"){
            curr1 = "Y";
            servo01.write(-1 * mov90);
            delay(700);          
          }
          
          if(servoNum == "X"){
            curr1 = "X";
            servo01.write(-1 * mov90);
            delay(700);
            servo01.write(-1 * mov90); 
            delay(700);
          } 
        }
            
      }else{     
        if(curr2 == "ACE" ){
          if(servoNum == "BDF"){
            Serial.println("HERE PLEASE");
            curr2 = "BDF";
            Serial.println(movSix);
            servo02.write(movSix); 
            delay(700);
          }
        }
        if(curr2 == "BDF" ){
          if(servoNum == "ACE"){
            curr2 = "ACE";
            servo02.write(-1 * movSix); 
            delay(700);
          }
        }
      }  
    }else{
      if( servoNum == "X" || "Y" || "Z" ){
        
        if(curr1 == "Y"){
          if(servoNum == "X"){
            curr1 = "X";
            servo01.write(-1 * mov90);
            delay(700+timetoMove);
            servo01.write(mov90);
            delay(700);
          }

          if(servoNum == "Z"){
            curr1 = "Z";
            servo01.write(mov90);
            delay(700+timetoMove);
            servo01.write(-1 * mov90); 
            delay(700);
          }          
        }
  
        if(curr1 == "X" ){
          if(servoNum == "Y"){
            curr1 = "Y";
            servo01.write(mov90);
            delay(700+timetoMove);
            servo01.write(-1 * mov90);
            delay(700);          
          }
          
          if(servoNum == "Z"){
            curr1 = "Z";
            servo01.write(mov90);
            delay(700);
            servo01.write(mov90);
            delay(700+timetoMove);
            servo01.write(-1 * mov90);
            delay(700);
            servo01.write(-1 * mov90); 
            delay(700);
          }
        }
       
        if(curr1 == "Z"){
          if(servoNum == "Y"){
            curr1 = "Y";
            servo01.write(-1 * mov90);
            delay(700+timetoMove);
            servo01.write(mov90);
            delay(700);
          }

          if(servoNum == "X"){
            curr1 = "X";
            servo01.write(-1 * mov90);
            delay(700);
            servo01.write(-1 * mov90);
            delay(700+timetoMove);
            servo01.write(mov90);
            delay(700);
            servo01.write(mov90);
            delay(700);          
          }          
        }
           
      }else{
        if(curr2 == "ACE"){
          if(servoNum == "BDF"){
            curr2 = "BDF";
            servo02.write(movSix);
            delay(700+timetoMove);
            servo02.write(-1 * movSix ); 
            delay(700);
          }
        }
        if(curr2 == "BDF"){
          if(servoNum == "ACE"){
            curr2 = "ACE";
            servo02.write(-1 * movSix);
            delay(700+timetoMove);
            servo02.write(movSix); 
            delay(700);
          }          
        }
      }
    }
  stringComplete = false;    
  }
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
        servoNum += inChar;
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
