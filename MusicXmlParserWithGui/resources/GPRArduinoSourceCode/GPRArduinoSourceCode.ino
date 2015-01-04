 #include <Servo.h> 

//////////////////// STATIC DEFINITIONS////////
int servoPushValue=80;
int servoPullValue=0;
int servoTouch1Value=0;
int servoTouch0Value=10;
int pos1Value=10;
int pos2Value=50;
int pos3Value=90;
int pos4Value=130;
int pos5Value=170;
//////////////////////////////////////////////

Servo servo1push; //2
Servo servo1position; //3
Servo servo1touch; //4

Servo servo2push; //5
Servo servo2position; //6
Servo servo2touch; //7

Servo servo3push; //8
Servo servo3position; //9
Servo servo3touch; //10


int pos1;
int pos2;
int pos3;

boolean touch1;
boolean touch2;
boolean touch3;

void setup() 
{ 
  Serial.begin(9600);
  servo1push.attach(2); //2
  servo1position.attach(3); //3
  servo1touch.attach(4); //4
  servo2push.attach(5); //5
  servo2position.attach(6); //6
  servo2touch.attach(7); //7
  servo3push.attach(8); //8
  servo3position.attach(9); //9
  servo3touch.attach(10); //10
  
  pos1=0;
  pos2=0;
  pos3=0;
  
  touch1=true;
  touch2=true;
  touch3=true;
} 


void loop() 
{ 
   if (Serial.available() > 0) {
     comingCommand(Serial.read());    
   }
}

void comingCommand(int command){
  if(command<70){
    setPosition((command/10),(command%10));
  }else{
    if(command<90){
      pushPull(command);
    }else{
      touch(command%10);
    } 
  }
}
void pushPull(int command){
  if(command/10==6){
    push(command%10);
  }else{
    pull(command%10);
  }
}
void push(int line){
  switch(line){
    case 1:
    if(pos1!=0){
      servo1push.write(servoPushValue);
    }
    break;
    case 2:
    if(pos2!=0){
      servo2push.write(servoPushValue);
    }
    break;
    case 3:
    if(pos3!=0){
      servo3push.write(servoPushValue);
    }
    break;
    case 4:
    break;
    case 5:
    break;
    case 6:
    break;
  }
}
void pull(int line){
  switch(line){
     case 1:
      if(pos1!=0){
      servo1push.write(servoPullValue);
    }
    break;
    case 2:
    if(pos2!=0){
      servo2push.write(servoPullValue);
    }
    break;
    case 3:
    if(pos3!=0){
      servo3push.write(servoPullValue);
    }
    break;
    case 4:
    break;
    case 5:
    break;
    case 6:
    break;
  }
}
void setPosition(int line,int pos){
  int valueForPosition=0;
  
  switch(pos){
  case 1:
  valueForPosition = pos1Value ;
  break;
  case 2:
  valueForPosition = pos2Value;
  break;
  case 3:
  valueForPosition = pos3Value;
  break;
  case 4:
  valueForPosition = pos4Value;
  break;
  case 5:
  valueForPosition = pos5Value ;
  break;
  default:
  valueForPosition = 90;
  break;
  }
  
  
  
  switch(line){
    case 1:
      pos1=pos;
      servo1position.write(valueForPosition);
    break;
    case 2:
      pos2=pos;
      servo2position.write(valueForPosition);
    break;
    case 3:
      pos3=pos;
      servo3position.write(valueForPosition);
    break;
    case 4:
    break;
    case 5:
    break;
    case 6:
    break;
  }
}

void touch(int line){
  switch(line){
    case 1:
      if(touch1){
        servo1touch.write(servoTouch0Value);
      }else{
        servo1touch.write(servoTouch1Value);
      }
      touch1= (!touch1);
    break;
    case 2:
      if(touch2){
        servo2touch.write(servoTouch0Value);
      }else{
        servo2touch.write(servoTouch1Value);
      }
      touch2= (!touch2);
    break;
    case 3:
      if(touch3){
        servo3touch.write(servoTouch0Value);
      }else{
        servo3touch.write(servoTouch1Value);
      }
      touch3= (!touch3);
    break;
    case 4:
    break;
    case 5:
    break;
    case 6:
    break;
  }
}
