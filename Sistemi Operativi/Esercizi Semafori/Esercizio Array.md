```c
/* 
Si consideri un array di int A, di dimensione 4, inizializzato a [0, 0, 0, 0],

si assumano i seguenti processi:

- WP: mosidicano gli elementi di indice pari, sommando 1 a tali elementi;

- WD: modificano gli elementi di indice dispari, sommando 1 a tali elementi;

- WT: modificano tutti gli elementi, sommando due a tali elementi;

- R: leggono gli elementi dell'array e ne calcolano la somma, assegnandika ad una     variabile privata

Programmare le 4 tipologie di processo, nel rispetto dei seguenti viincoli:

- i semafori devono essere usati assumento la semantica tradizionale, le uniche operazioni concesse sono wait e signal

- race condition su S e sui singoli elementi di A devono essere impossibili;

- nessun processo deve essere in waiting senza ragione. Vale a dire, se un processo è in attesa allora l'accesso all'array di tale processo violerebbe la condizione precedente.
*/

int A[4] = [0, 0, 0, 0];
sem mutex_pari = 1; 
/*gestisco la muta esclusione degli elementi di indice pari*/
sem mutex_dispari = 1;
/*gestisco la muta esclusione degli elementi di indice dispari*/

processoWP({
  wait(mutex_pari);

  A[0] = A[0] + 1;
  A[2] = A[2] + 1;

  signal(mutex_pari);
})

processoWD(){
  wait(mutex_dispari);

  A[1] = A[1] + 1;
  A[3] = A[3] + 1;

  signal(mutex_dispari);
}

processoWT(){

  wait(mutex_pari);
  wait(mutex_dispari);

  A[0] = A[0] + 2;
  A[1] = A[1] + 2;
  A[2] = A[2] + 2;
  A[3] = A[3] + 2;

  signal(mutex_pari);
  signal(mutex_dispari);
}

processoR(){
  wait(mutex_pari);
  wait(mutex_dispari);

  int z = A[0] + A[1] + A[2] + A[3];

  signal(mutex_pari);
  signal(mutex_dispari);
}
```