# Memoria

## Riutilizzo della Memoria

Il problema di allocazione della memoria può essere visto a due livelli:

- il SO deve allocare la memoria per i processi;
- all'interno della memoria di un processo, il RTS del linguaggio deve alloracare memoria per i PCD.

In entrambi i casi, è necessario riutilizzare la memoria liberata. Per poterlo fare, bisogna tener traccia di quali blocchi di memoria sono occuoati e quali sono liberi.  
Una possibile soluzione è l'uso di una **free list**:  

- si ha un puntatore al primo blocco libero;
- ogni blocco libero contiene:
  - un campo che ne indica la dimensione;
  - un puntatore al blocco succesivo;
  - **opzionalmente**, un puntatore al blocco precedente.
  > questo se si vuole realizzare una double linked list.

Quando una free list viene usata dal sistema operativo (per terenere traccia della memoria assegnabile ai processi), il puntatore al primo blocco è una variabile situata nella kernel area.

## Tecniche di allocazione

Quando si vuole avviare un programma, in un sistema con allocazione contigua, il SO deve trovare un blocco libero abbastanza grande da contenere l'intero programma.

In generale, in un sistema che gestisce la memoria libera mediante una free list, per allocare un'area contigua di dimensione `n` byte è necessario cercare nella lista un blocco livero di dimensione >= `n`.
Se la sua dimensione è `d`, dopo aver allocato i `n` byte richiesti si ha ancora un'area libera di `d - k` byte, che rimane nella free list.
Esistono almeno tre tecniche diverse per effettuare la ricerca: