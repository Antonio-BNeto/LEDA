package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 *
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse problema,
     *       identifique que métodos você precisará para resolver o problema 
	 *       e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		T result = array[searchMin(array)];
		if(k>1){
			for(int i = 2;i<k;i++){
				result = selectMinGreater(array, result);
			}
		}
		return result;
	}

	private int searchMin(T[] array){
		int min = 0;
		for(int i = 0;i<array.length;i++){
			if(array[i].compareTo(array[min])<0){
				min = i;
			}
		}

		return min;
	}
	
	private T selectMinGreater(T[] array, T previous){
		T candidate = null;

		for(int j = 0;j< array.length;j++){
			if (array[j].compareTo(previous)>0) {
				if(candidate == null){
					candidate = array[j];
				}else{
					if(array[j].compareTo(candidate)<0){
					candidate = array[j];
					}	
				}
			}
		}
		return candidate;
	}

}
