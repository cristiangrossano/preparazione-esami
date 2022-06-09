# Esercizi Semafori

## Problema dello sleeping barber

In un barber shop lavora un solo barbiere, vi è una sola sedia adibita al taglio, e vi sono N sedie per i clienti in attesa.
Assumiamo N=20.

### Comportamento del barbiere

- all'apertura del negozio si mette a dormire nella sedia adibita al taglio, in attesa che un cliente entri e lo svegli;
- quando ci sono clienti in attesa, il barbiere li chiama e li serve uno alla volta;
- quando non ci sono clienti in attesa, il barbiere si rimette a dormire nella sedia adibita al taglio.

### Comportamento del cliente

- quando entra nel negozio, se non ci sono sedie libere va a cercarsi un
  altro barbiere;
- quando entra nel negozio, se c'è almeno una sedia libera ne occupa una, svegliando il barbiere se sta dormendo, ed attendendo di essere chiamato dal barbiere per il taglio.

### Programmare il barbiere ed il singolo cliente

```c
semaphore clients_in_shop = 0;
barber_free = 0;
mutex = 1;

int waiting_clients = 0; //variabile condivisa

final int CHAIRS = 20;

barbiere(){
  while(true){
    wait(clients_in_shop);
    wait(mutex);
    waiting_clients = waiting_clients - 1;
    signal(barber_free);
    signal(mutex);
    cut_hair()
  }
}

cliente(){
  wait(mutex);
  if(waiting_clients < CHAIRS){
    waiting_clients = waiting_clients + 1;
    signal(client_in_shops);
    signal(mutex);
    receive_cut();
  } else {
    signal(mutex)
  }
}
```



