# Formule Probabilità e Statistica per l'Informatica

## Eventi Indipendenti

$$ P(A | B) = P(A) * P(B) $$

### Esempio

Calcolare la probabilità che piova per due giorni di fila, con $p = 45%$.  
 Sono due eventi indipendenti in quanto che piova un giorno non influenza il giorno dopo.
$P(A)$ = pioggia giorno 1
$P(B)$ = pioggia giorno 2

$$
P(A|B) = \frac{45}{100}* \frac{45}{100} = \frac{81}{400} = 0, 2025
$$

---

## Eventi Dipendenti

$$ P(A e B) = P(A) * P(B | A) $$

### Esempio 1

Estraggo da un sacchetto che contiene 5 palline blue, 4 palline verdi e 7 palline rosse senza reinserire le palline rimosse. Per trovare la probabilità che entrambe siano blu:

$$
P (Blu e Blu) = \frac{5}{16}+\frac{4}{15} = \frac{1}{12} = 0.0833
$$

### Esempio 2

Da una classe di 36 studenti (dove 20 sono femmine e 16 sono maschi) qual è la probabilità di estrarre prima un maschio e poi una femmina.  

$$
P (maschio) * P(femmina|maschio) = \frac{16}{36} * \frac{20}{35}=\frac{16}{63}=0, 2540
$$

### Esempio 3

Da una classe di 36 studenti (dove 20 sono femmine e 16 sono maschi) qual è la probabilità di estrarre prima una femmina e poi un maschio.  

$$
P (maschio) * P(femmina|maschio) = \frac{20}{36} * \frac{16}{35}=\frac{16}{63}=0, 2540
$$

---

## Probabilità di unione

$$
P(A o B) = P(A) + P(B) - P(AeB)
$$

### Esempio  

voti    | 10 | 9  | 8  | Totale
--------|----|----|----|-------
Maschio | 18 | 19 | 3  | 40
Femmina | 12 | 4  | 9  | 25
Totale  | 30 | 23 | 12 | 65

Un gruppo di studenti che ha fatto un test, uno studente a caso è stato scelto. Qual è la probabilità che lo studente sia una ragazza oppure che abbia preso 8.  

$$
P(R o 8) = \frac{25}{65}+\frac{12}{65} - \frac{9}{65} = \frac{28}{65} = 0, 4308
$$

---

### Probabilità Complementare

$$
P(A) = \frac{casifavorevoli}{totale risultati}
$$
$$
P(notA) = P(\overline{E}) = 1 - P(E)
$$

### Esempio

Considerando un gruppo di studenti con voti e genere riassunti nella tabella.  
Se uno studente viene scelto a caso, qual è la probabilità che lo studente scelto **non** abbia preso 9?  

voti    | 10 | 9  | 8  | Totale
--------|----|----|----|-------
Maschio | 18 | 19 | 3  | 40
Femmina | 12 | 4  | 9  | 25
Totale  | 30 | 23 | 12 | 65

$$
P(notB)=\frac{30+12}{65}= \frac{42}{65}
$$
$$
P(notB)=1-P(B) = 1 - \frac{42}{65} = \frac{23}{65}
$$

---

## Probabilità Condizionata

$$
P(E_2|E_1)=\frac{P(E_2 e E_1)}{P(E_1)}
$$

### Esempio

Si hanno 12 palline.  
Ogni pallina può essere rossa o blu e ogni pallina è numerata da 1 a 5 come mostrato sotto.

![palline_rosse_blu](https://cdn.discordapp.com/attachments/981502253796040744/992152886643531776/Schermata_del_2022-06-30_21-41-07.png)

Qual è la probabilità che la pallina estratta sia rossa e dispari?

$$
P(Rossa|Dispari) = \frac{6}{10}
$$

### Spiegazione

La probabilità di un evento $E_2$ che si verifica solo se precedentemente si è verificato un  evento $E_1$.  

---

## Probabilità Binomiale / Bernoulli

$$
P(x=k) = \frac{n!}{k!*(n-k)!}*p^k * (1-p)^{n-k}
$$

### Esempio

Abbiamo 8 oggetti in totale, con una probabilità p del 0, 2 per ogni estrazione.

$$
P(x = 1) = \frac{8!}{1!*7!}*0, 2^1*(1-0, 2)^{8-1}
$$ 

---

## Probabilità Ipergeometrica

$$
P(x = k) = \frac{\frac{S}{k}*\frac{N}{N-k}}{\frac{n}{k}}
$$

---

## Combinazioni Semplici

$$
C_{n, k} = \frac{D_{n.k}}{k!}=\frac{n!}{((n-k)!*k!)}
$$

---

## Combinazioni con Ripetizione

$$
C_{n+k-1, k} = (\frac{n+k-1}{k})=\frac{D_{n+k-1, k}}{k!}=\frac{(n+k-1)!}{((n-1)!*k!)}
$$

---

## Disposizioni Semplici

$$
D_{n,k} = n(n-1)(n - 2)...(n-k+1)= \frac{n!}{(n-k)!}
$$

---

## Teorema di Bayes

$$
P(A|B) = \frac{P(A)*P(B|A)}{P(A)*P(B|A)+P(\overline{A})*P(B|\overline{A})}
$$

### Esempi

Un certo virus infetta 1 persona 400 persone.  
Uno test usato per rilevare il virus è positivo l'85% delle volte se la persona ha il virus e il 5% delle volte se non ce l'ha.  

$ P(A) $ una persona ha il virus;
$ P(B) $ la persona risulta positiva.

$ P(A)= \frac{1}{400} = 0.0025 $
$ P(\overline{A})= \frac{399}{400} = 0.9975 $
$ P(B|A) = 85\% = 0.85 $
$ P(B|\overline{A}) = 5\% = 0.05 $

---
