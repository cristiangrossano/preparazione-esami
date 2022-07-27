# basi di dati

## TEORIA

## ESERCIZI

### Esercizio 1

STADIO( **Nome**, Città, Capienza )  
SQUADRA( **Nazione**, Data_qualifica, Capitano, Mondiali_vinti )  
PARTITA( **Stadio** , **Data**, Squadra1, Squadra2, Goal1, Goal2, Spettatori )  
GIOCATORE( **Codice**, Nome, Cognome, Squadra, Età, Ruolo )

Dove gli attributi in grassetto costituiscono la chiave della relazione.  
Goal1 e Goal2 indicano i goal segnati durante una partita dalle due squadre che si sfidano (squadra1 e squadra2).

1. Identificare le chiavi esterne presenti nello schema indicando, per ognuna di esse, relazione
referente e riferita

2. Scrivere i comandi SQL per:

- Creare una vista che contenga il nome delle squadre il cui capitano ha meno di 20 anni.
- Aggiungere un vincolo che stabilisca che l’età di un giocatore non può essere inferiore a 17 anni.
- Aumentare di una unità il numero di mondiali vinti dal Belgio.
