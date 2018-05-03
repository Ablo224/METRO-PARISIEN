
/**
 * @author (Balde Abdoulaye - Mouhani Allan)
 *
 */


public class Noeud implements Comparable {

  final int id; // identifiant
  final int val; // valeur

  // constructeur
  Noeud(int i, int v){
    id = i;
    val = v;
  }

  // fonction de comparaison
  public int compareTo(Object o1) {
    Noeud n = (Noeud) o1;
    if (this.val == n.val) return (this.id - n.id);
    return this.val - n.val;
  }
}
