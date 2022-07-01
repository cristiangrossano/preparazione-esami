# Probabilità e statistica per l'informatica

## Lezione 1

Si chiama spazio campionario l'insieme di tutti i possibili risultati di un esperimento.
Esso può essere infinito oppure viene rappresentato con Ω.

**Esempio**: Lancio di una moneta.
Ω = (T; T ); (T; C); (C; T ); (C; C)

Esperimenti diversi possono avere lo stesso spazio campionario.
Dato uno spazio campionario si chiama **_evento_** ogni sottoinsieme di Ω.
L'insieme di tutti gli eventi di Ω si indica con **_P(Ω)_** e si chiama **_spazio degli eventi_**.

**Esempio**: Lancio di una moneta.

- Ω = {T, C}
- P(Ω) = {{T}, {C}, Ω, ∅}

Se abbiamo come spazio campionario Ω e come evento abiamo A ⊆ Ω.
Diciamo che l'evento A si verifica se e solo se x ∈ Ω.

**Esempio**: Lancio di un dado.
Considerando l'evento A = {1, 3, 5}.

- Con x = 1, l'evento _si verifica_
- con x = 2, l'evento _non si verifica_

Un evento si definisce **_elementare_** se la sua cardinalità è **_uguale a uno_**. (#A = 1)
Es: A = {1}

Un evento si definisce **_impossibile_** quando in nessun caso può verificarsi.
Si rappresenta con l'insieme vuoto. (∅ / {})
Es: Dal lancio di un dado esca un numero maggiore di 7

Un evento si definisce **_certo_** quando la condizione si avvererà in ogni caso.
Un evento certo si rappresenta con Ω.
Es: Dal lancio di un dado esca un numero minore di 7

Avendo A, B ⊆ Ω.
L'**_evento unione_** di A e B si indicano con AUB.
Si tratta dell'evento che si verifica se e solo se **_si verifica_**

- A;
- B;
- entrambi.

Es: Lancio di un dado.

- A = {1}
- B = {2}.
L'unione di A e B = A U B = {1} U {2} = {1, 2}

Un evento si definisce **_evento intersezione_** quando sia A che B si vericano.
Es: Lancio di un dado
A: 'esce un numero pari' = A = {2, 4, 6}.
B: 'esce un numero minore di 5 = B = {1, 2, 3, 4}.
A ∩ B = {2, 4, 6} ∩ {1, 2, 3, 4} = {2, 4}

Un evento si definisce **_contrario_** (o **_complementare_**) un evento che si verifica se e solo se A non si verifica.
Si indica con Ā.

> **_Ogni evento è l'unione di eventi elementari._**

Un evento si definisce **_incompatibile_** se e solo se non possono verificarsi insieme.
Due eventi sono incompatibili se e solo se l'intersezione dei due eventi è un insieme vuoto.
Es: Lancio di un dado.
A = esce un numero pari = {2, 4, 6}.
B = esce un numero dispari = {1, 3, 5}.
A ∩ B = ∅.

### Probabilità classica

Considerando lo spazio campionario Ω e supponiamo che gli eventi elementari siano equiparabili (stessa probabilità di verificarsi).
La probabilità dell'evento A relativo a Ω è:

```
    P(A) =  #A
            #Ω  
```

##  DOMANDE DI TEORIA

- enuncia il teorema di bayes
- teorema della probabilità totali
