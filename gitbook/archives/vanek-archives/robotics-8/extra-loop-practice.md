# Extra Loop Practice

{% embed url="https://youtu.be/wf5pHCQIvU4" %}



```
void setup()
{
  Serial.begin(9600);
  
  Serial.println("1 to 10 by 1");
  for (int i = 1; i < 11; i= i+1)
  {
    Serial.println(i);
  }
  
  
  Serial.println("0 to 1000 by 100");
  
  
  Serial.println("50 to 0 by 10");
  
  
  Serial.println("0 to -10 by 1");
  
  
  Serial.println("-25 to 75 by 25");
  
  
  Serial.println("10 to -10 by 2");
  
  
  Serial.println("7 to 49 by 7");

  
  Serial.println("100 to 25 by halfing the number");

  
  Serial.println("5 to 320 by doubling the number");

}



void loop()
{
  ///NOTHING GOES HERE
}
```

