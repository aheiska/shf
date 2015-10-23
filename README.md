
FP-intro dojo @ tty
===================

## Alkukalvot

* funktiot ensimmäisen luokan kansalaisina
* //lambda ja sulkeuma
* immutable lista
 * miltä näyttää?
 * scala 1 :: (2 :: (3 :: Nil))
 `sealed trait List[T];`
 `case object Nil extends List[Nothing]`
 `case class Cons extens List[T]`
 * haskell 1 : (2 : (3 : []))
 `data List a = Nil | Cons a`
 * F# `type List<'a> = Nil | Cons ....`
* type inference?
 * Maininta mitä on
* pattern matching
 * Pakko avata vähän, että tehtävien tekeminen on järkevää
 * "Eikö olisi näppärää, jos ei aina tarttisi iffitellä mitä tyyppiä saatiin"
* ohjelmointi ilman muuttuvaa tilaa ja silmukoita

## Tehtävät

Näistä kaikista näytetään jokin perusratkaisu ensin. Sen jälkeen tehtävänä pari lähes samanlaista itse koodaten. Imo malliratkaisu voi paistua kalvoilla sen aikaa.

0. Reduce
* Map
* Filter
* Fold

## Ehtiikö?
* Jokin "isompi" tehtävä, viitenumeron laskenta, iban-numeron validointi?
 - näille stubi, täydennä funktiot?

## Lopuksi:
* Opitte jotain millä on on hyvin vähän tekemistä oikean FP:n kanssa. Anteeksi.
*
