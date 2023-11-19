//12-bit default resolution; external power supply
#include<OneWire.h>
OneWire ds(2);
byte addr[8];         //to hold 64-bit ROM Codes of DS1
byte data[9];        //buffer to hold data coming from DS18B20
float celsius;

void setup() 
{
  Serial.begin(9600);
 
  ds.reset();
  ds.search(addr);  //collect 64-bit ROM code from sensor
}

void loop()
{
  probe();
  delay(1000);
}

void probe()
{
 //----------------------------
 ds.reset();       //bring 1-Wire into idle state
 ds.select(addr); //slect with DS-1 with address addr1
 ds.write(0x44);    //conversion command
 delay(1000);   //data ready withinh DS18B20 or poll status word
 //---------------------------
 ds.reset();
 ds.select(addr);  //selectimg the desired DS18B20
 ds.write(0xBE);    //Function command to read Scratchpad Memory (9Byte)
 ds.read_bytes(data, 9); //data comes from DS and are saved into buffer data[8]
 //---------------------------------
  int16_t raw = (data[1] << 8) | data[0]; //---data[0] and data[1] contains temperature data : 12-bit resolution-----
  celsius = (float)raw / 16.0;  //12-bit resolution
  Serial.println(celsius);
}