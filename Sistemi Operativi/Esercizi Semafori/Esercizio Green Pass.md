```c
/*
Un negozio può ospitare al massimo 50 clienti, che sono classificati come "clienti con green pass
base" e " clienti con green pass rafforzato". Programmare l'ingresso nel negozio ed uscita dal negozio dei
thread "cliente con green pass base" e "cliente con green pass rafforzato".
E' necessario rispettare i seguenti vincoli:
 a. Se nel negozio sono già presenti 50 clienti, nessun cliente può entrare.
 
 b. Anche nel caso in cui nel negozio ci siano meno di 50 clienti, i clienti con green pass base non
 possono entrare se nel negozio sono già presenti almeno 10 clienti con green pass base oppure se il 
 negozio ospita già almeno 18 clienti e la frazione di clienti con green pass base è maggiore di 1/3.
 
 c. Il cliente che desidera entrare nel negozio ma non può farlo deve essere messo in attesa
 
 d. Se un cliente è in attesa di entrare in negozio allora il suo ingresso violerebbe la condizione
 "a" oppure la condizione "b" (no attese senza ragione).
*/

mutex = 1, gpBase = 0, gpRafforzato = 0;
int posti = 50, frazione = 3, attesaBase = 0, attesaRafforzato = 0, gpBaseIn = 0, gpRafforzatoIn = 0;

greenpassBase(){
 entraGPBase();
 compra();
 esceGPBase();
}

greenpassRafforzato(){
 entraGPRafforzato();
 compra();
 esceGPRafforzato();
}

entraGPBase(){
 wait(mutex);
 if(posti < 50 && gpBaseIn <= 10 || posti < 50 && gpBaseIn <= posti / frazione){
  gpBaseIn++;
  posti--;
  signal(mutex);
 }else{
  attesaBase++;
  signal(mutex);
  wait(gpBase);
 }
}

entraGPRafforzato(){
 wait(mutex);
 if(posti < 50){
  posti--;
  gpRafforzatoIn++;
  signal(mutex);
 }else{
  attesaRafforzato++;
  signal(mutex);
  wait(gpRafforzato);
 }
}

esceGPBase(){
 wait(mutex);
 posti--;
 gpBaseIn--;
 if(attesaBase > 0 || attesaRafforzato > 0){
  if(attesaRafforzato >= attesaBase){
   posti--;
   gpRafforzatoIn++;
   signal(gpRafforzato);
  }else{
   if(posti < 50 && gpBaseIn <= 10 || posti < 50 && gpBaseIn <= posti / frazione){
    gpBaseIn++;
    posti--;
    signal(gpRafforzato);
   }
  }
 }
 signal(mutex);
}

esceGPRafforzato(){
 wait(mutex);
 posti--;
 gpRafforzatoIn--;
 if(attesaBase > 0 || attesaRafforzato > 0){
  if(attesaRafforzato >= attesaBase){
   posti--;
   gpRafforzatoIn++;
   signal(gpRafforzato);
  }else{
   if(posti < 50 && gpBaseIn <= 10 || posti < 50 && gpBaseIn <= posti / frazione){
    gpBaseIn++;
    posti--;
    signal(gpRafforzato);
   }
  }
 }
 signal(mutex);
}
```

