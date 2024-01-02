package proyecto1_carlosgarita;

//Clase "Métodos" para ejecutar cada uno de los 3 métodos de ordenamiento en análisis
public class Metodos {

    //Declaración de las variables de instancia
    int arreglo[];
    
    //Método constructor
    public Metodos(int ar[]) {
        
        //Asigna los valores recibidos en el constructor a cada una de las variables de instancia correspondientes
        this.arreglo = ar;
    }    
    
    //Método para ejecutar el ordenamiento por em método de Burbuja
    public int[] burbuja() {
        
        //Declaración de variables locales
        int num;
        
        //Ciclo for para recorrer el arreglo en la posición "i"
        for (int i = 0; i < arreglo.length - 1; i++) {
            
                    //Ciclo for para recorrer el arreglo en la posición "j"
            for (int j = 0; j < arreglo.length - 1; j++) {
                
                //Condicional para determinar si el número en la posición "j" del arreglo es mayor al número en la posición "j+1" del arreglo
                if (arreglo[j] > arreglo[j + 1]) {
                    
                    num = arreglo[j + 1]; //Asigna el valor del arreglo en la posición "j+1" a la variable "num"
                    arreglo[j + 1] = arreglo[j]; //Asigna el valor del arreglo en la posición "j" al arreglo en la posición "j+1"
                    arreglo[j] = num; //Asigna el valor de la variable "num" al arreglo en la posición "j"
                }
            }
        }    
        
        //Regrea el arreglo ordenado
        return arreglo;
    }

    //Método para ejecutar el ordenamiento por em método de Sellsort
    public int[] shell() {
        
        //Declaración de variables locales
        int num, j, k, salto;
        
        //Asigna el valor de la mitad de la longitud del arreglo a la variable "salto"
        salto = arreglo.length/2;
        
        //Ciclo que se ejecuta mientra que la variable "salto" sea mayor a cero
        while(salto > 0){
            
            //Ciclo for para recorrer el arreglo en la posición "i"
            for(int i = salto; i < arreglo.length; i++){
                j = i - salto; //Asigna el valor de "i-salto" a la variable "j"
                
                //Ciclo que se ejecuta mientras "j" sea mayor o igual a cero
                while(j >= 0){
                    k = j + salto; //Asigna el valor de "j+salto" a la variable "k"
                    
                    //Condicional que se ejecuta cuando el número del arreglo en la posición "j" es menor o igual al número del arreglo en la posición "k"
                    if(arreglo[j] <= arreglo[k]){
                        j = -1; //Asigna un "-1" a la variable "j"
                    }else{
                        num = arreglo[j]; //Asigna el valor del arreglo en la posición "j" a la variable "num"
                        arreglo[j] = arreglo[k]; //Asigna el valor del arreglo en la posición "k" al arreglo en la posición "j"
                        arreglo[k] = num; //Asigna el valor de la variable "num" al arreglo en la posición "k" 
                        j -= salto; //Resta "j-salto" y lo asigna a la varianle "j"
                    }
                }
            }            
            salto = salto/2; //Divide el valor de "salto" entre 2 y lo asigna a la variable salto           
        }        
        return arreglo;                             
    }

    //Método para ejecutar el ordenamiento por em método de Quicksort
    public int[] quick(int izquierdo, int derecho) {
        
        //Declaración de variables locales
        int izq = izquierdo, der = derecho, pivote = (izquierdo+derecho)/2, num;        
        
        //Condicional que se ejecuta cuando el valor de izquierdo es mayor o igual que el valor derecho
        if (izquierdo >= derecho) {
            return arreglo; //Regrea el arreglo 
        }else{
            
            //Condicional que se ejecuta cuando el valor de izquierdo es diferente al valor derecho      
            if(izquierdo != derecho){                       
            
            //Ciclo que se ejecuta mientras izquierdo sea diferente de derecho    
            while(izquierdo != derecho){
                
                //Ciclo que se ejecuta cuando el número del arreglo en la posición del número derecho es mayor o igual que el número del arreglo en la posición del número pivote y además 
                //el número izquierdo en menor que el número derecho
                while(arreglo[derecho] >= arreglo[pivote] && izquierdo < derecho){
                    derecho--; //Resta un 1 a derecho
                }
                
                //Ciclo que se ejecuta cuando el número del arreglo en la posición del número izquierdo es menor o igual que el número del arreglo en la posición del número pivote y además 
                //el número izquierdo en menor que el número derecho
                while(arreglo[izquierdo] < arreglo[pivote] && izquierdo < derecho){
                    izquierdo++; //Suma un 1 a izquierdo
                }
                
                //Condicional que se ejecuta cuando derecho es diferente a izquierdo
                if(derecho != izquierdo){
                    num = arreglo[derecho]; //Asigna el valor del arreglo en la posición del número derecho a la variable "num"
                    arreglo[derecho] = arreglo[izquierdo]; //Asigna el valor del arreglo en la posición del número izquierdo al arreglo en la posición del número derecho
                    arreglo[izquierdo] = num; //Asigna el valor de la variable "num" al arreglo en la posición del número izquierdo
                }                
            }
            
            //Condicional que se ejecuta cuando izquierdo es igual a derecho
            if(izquierdo == derecho){
                quick(izq,izquierdo - 1); //Llama al método "quick" de forma recursiva
                quick(izquierdo + 1,der); //Llama al método "quick" de forma recursiva
            }                              
        }else{
                
            //Regrea el arreglo
            return arreglo;
        }        
            
        //Regrea el arreglo ordenado    
        return arreglo;       
        }                    
    }
}
