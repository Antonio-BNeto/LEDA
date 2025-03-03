package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento
	 *            este array normalmente nao esta ordenado
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 *
	 */
	public T quickSelect(T[] array, int k) {
		T result = null;
		if(array.length != 0 && k <= array.length && k > 0){
			result = select(array, 0, array.length-1, k);
		}
		return result;
	}

	private T select(T[] array, int leftIndex, int rightIndex, int k){

		if(leftIndex == rightIndex){
			return array[leftIndex];
		}

		medianThree(array, leftIndex, rightIndex);
		int pivotIndex = partition(array, leftIndex+1, rightIndex-1);

		T result = array[pivotIndex];

		if(pivotIndex == k-1){

		}else if(pivotIndex < k-1){
			result = select(array, pivotIndex + 1, rightIndex, k);
		}else{
			result = select(array, leftIndex, pivotIndex-1, k);
		}

		return result;
	}

	private void medianThree(T[] array, int leftIndex, int rightIndex){

		int meio = (leftIndex + rightIndex) / 2;

		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, rightIndex, leftIndex);
		}
		if (array[leftIndex].compareTo(array[meio]) > 0) {
			Util.swap(array, meio, leftIndex);
		}
		if (array[meio].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, rightIndex, meio);
		}
		if (rightIndex-leftIndex>=2) {
			Util.swap(array,meio, leftIndex+1);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex){

		int pivot = leftIndex;
		int i = leftIndex;

		for(int j = i+1; j<=rightIndex;j++){
			if(array[j].compareTo(array[pivot])<= 0){
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex , i);

		return i;
	}
}