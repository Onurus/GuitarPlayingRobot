 #include <Servo.h> 

//////////////////// STATIC DEFINITIONS////////
int servo2pull0=80;
int servo2push1=50;
int servo2push2=112;

int servo3pull0=80;
int servo3push3=45;
int servo3push4=110;

int servo4touch0=70;
int servo4touch1=100;

int servo5pull0=90;
int servo5push1=150;
int servo5push2=30;

int servo6pull0=90;
int servo6push3=138;
int servo6push4=32;

int servo7touch0=110;
int servo7touch1=130;
//////////////////////////////////////////////

Servo servo2; //2
Servo servo3; //3
Servo servo4; //4

Servo servo5; //5
Servo servo6; //6
Servo servo7; //7

boolean touch1;
boolean touch2;

void setup() 
{ 
  Serial.begin(9600);
  servo2.attach(2); //2
  servo3.attach(3); //3
  servo4.attach(4); //4
  servo5.attach(5); //5
  servo6.attach(6); //6
  servo7.attach(7); //7
  
  
  servo2.write(servo2pull0);
  servo3.write(servo3pull0);
  servo4.write(servo4touch1);
  
  servo5.write(servo5pull0);
  servo6.write(servo6pull0);
  servo7.write(servo7touch1);
  
  touch1=true;
  touch2=true;
} 


void loop() 
{ 
  

   if (Serial.available() > 0) {
     comingCommand(Serial.read());    
   }
}

void comingCommand(int command){
  switch(command){
        case 10:
          servo2.write(servo2pull0);
          servo3.write(servo3pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6pull0);

    break;
        case 11:
          servo3.write(servo3pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6pull0);
          servo2.write(servo2push1); 
    break;
        case 12:
          servo3.write(servo3pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6pull0);
          servo2.write(servo2push2);
    break;
        case 13:
          servo2.write(servo2pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6pull0);
          servo3.write(servo3push3);
    break;
        case 14:
          servo2.write(servo2pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6pull0);
          servo3.write(servo3push4);
    break;
        case 71:
        if(touch1){
          servo4.write(servo4touch0);
        }else{
          servo4.write(servo4touch1);
        }
        touch1=!touch1;
    break;
        case 20:
          servo2.write(servo2pull0);
          servo3.write(servo3pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6pull0);;
    break;
        case 21:
          servo2.write(servo2pull0);
          servo3.write(servo3pull0);
          servo6.write(servo6pull0);
          servo5.write(servo5push1);
    break;
        case 22:
          servo2.write(servo2pull0);
          servo3.write(servo3pull0);
          servo6.write(servo6pull0);
          servo5.write(servo5push2);
    break;
        case 23:
          servo2.write(servo2pull0);
          servo3.write(servo3pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6push3);
    break;
        case 24:
          servo2.write(servo2pull0);
          servo3.write(servo3pull0);
          servo5.write(servo5pull0);
          servo6.write(servo6push4);
    break;
        case 72:
        if(touch2){
          servo7.write(servo7touch0);
        }else{
          servo7.write(servo7touch1);
        }
        touch2=!touch2;
    break;
  }
}
