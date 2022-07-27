# Architettura degli elaboratori

Il primo concetto da ricordare è quello dell'astrazione, cioè quello di semplificare il problema e non badare ai dettagli irrilevanti.

Per prima cosa potremmo costruire una macchina in grado di creare presentazioni power point, ma sarebbe una spesa eccessiva ed inutile.

Le cosa da fare sarebbero le seguenti:

    1.  Assemblare una macchina in grado di eseguire istruzioni elementari

    2.  Creare un sistema operativo su queste istruzioni elementari. (nota: per programmare un          sistema operativo non è necessario conoscere la macchina)

    3. scrivere programmi che si basano sulle funzioni messe a disposizione dal Sistema Operativo

Non dovendo conoscere come le machine sono fatte, è indifferente saperlo o meno:

Hardware e software sono equivalenti! Un elaboratore è caratterizzato da:

1

Le operazioni che è capace di compiere

2

Le istruzioni che è capace di eseguire, detto sintassi e linguaggio

3

La semantica che associa al linguaggio, quindi la funzione associata all'istruzione => suriettiva ma non iniettiva

⚠️=> al fine di descrivere ed applicare il linguaggio non è rilevante conoscere come viene eseguita l'istruzione richiesta (le operazioini che verranno svolte)

⚠️ => la funzione semantica non è iniettiva perché ad una istruzione corrispondono più operazioni

Linguaggio Macchina

Si definisce linguaggio macchina (L0) la sintassi compresa dal processore, detto M0 , che sarebbe il livello fisico più basso.

L0 è un linguaggio di base e binario, il linguaggio è legato al processore in quanto ogni processore ha un suo linguaggio.

Dato che costruire una macchina fisica su cui sia direttamente possibile programmare al linguaggio di alto livello sarebbe impossibile farlo slegatamente dal linguaggio del processore => utilizzando L0 si implementa una macchina virtuale M1 che comprende un linguaggio leggermente più evoluto, cioè L1, che viene utilizzato per costruire M1 andando avanti così.

Ogni volta che si sale nella scala gerarchica bisogna implementare un 'traduttore' che trasformi le istruzioni in comandi della macchina inferiore.

I traduttori sono di 2 tipi

Compilatore

Che crea un programma equivalente a quello utilizzato ma scritto con sintassi inferiore

Interprete

Traduce nello stesso momento il code eseguito

Il vantaggio di salire di macchina e processore è che si slega dal processore!

Livelli del calcolatore

Si è visto che si potrebbe astrarre all'infinito il linguaggio macchina, però i livelli usati più comunemente sono

5

Applicativo

4

Assembler

3

Sistema operativo

2

Instruction Set (ISA)

1

Microarchitettura

0

cioè come sono fatti i circuiti della macchina. L'insieme dei dati , operazioni e caratteristiche dei livelli sono sotto la definizione di "architettura".

I livelli 4 e 5 sono definiti come alti e la programmazione a questa altezza è definita di 'applicazioni'.

Usa linguaggi tecnici non a caso definiti di alto livello => vengono sempre compilati

livelli 1, 2 e 3 sono definiti come bassi, la programmazione viene definita di 'sistema' e usa il binario, sono sempre interpretati per una maggiore efficienza.

L1 - Microarchitettura

La microarchitettura si occupa di

    Elaborazione => Data Path

        Regitri general purpose come la memoria locale

        Unita logico aritmetica (ALU ) capace di eseguire semplici operazioni
