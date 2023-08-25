package ar.edu.unlu.poo.listadetareas;

import ar.edu.unlu.poo.pila.Nodo;

import java.time.LocalDate;

public class ListaDeTareas {
    NodoTarea prioridad = null;
    //la tarea con mas prioridad es el primer elemento de la lista
    // y mientras mas se recorra la lista menos prioridad tiene esa tarea

    public boolean es_vacia(){
        return prioridad == null;
    }
    public void agregar_tarea(String descripcion, LocalDate fecha, String estado){
        NodoTarea nuevo_nodo = new NodoTarea();
        nuevo_nodo.setDescripcion(descripcion);
        nuevo_nodo.setFechaLimite(fecha);
        nuevo_nodo.setEstado(estado);
        if (prioridad == null){
            prioridad = nuevo_nodo;
        }else {
            NodoTarea nodoAux = prioridad;
            while(nodoAux.getSiguiente() != null){
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nuevo_nodo);
        }
    }

    public void cambiar_descripcion(String descripcion, int pos){
        NodoTarea nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            nodoAux.setDescripcion(descripcion);
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            nodoAux.setDescripcion(descripcion);
        }
    }

    public void cambiar_estado(String estado, int pos){
        NodoTarea nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            nodoAux.setEstado(estado);
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            nodoAux.setEstado(estado);
        }
    }

    public void cambiar_prioridad(int pos_prioridad, int pos){
        NodoTarea nodoAux = prioridad;
        NodoTarea nueva_prioridad = prioridad;
        if(pos == 1){
            prioridad = nueva_prioridad.getSiguiente();
            for (int i = 0; i < pos_prioridad - 2;i++){
                nodoAux = nodoAux.getSiguiente();
            }
            nueva_prioridad.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nueva_prioridad);
        } else{
            for (int i = 0; i < pos - 2; i++){
                nodoAux = nodoAux.getSiguiente();
            }
            nueva_prioridad = nodoAux.getSiguiente();
            //tengo la tarea a la que se quiere cambiar su prioridad
            nodoAux.setSiguiente(nueva_prioridad.getSiguiente());
            //ahora busco la nueva posicion de la tarea que se le queria cambiar la posicion
            nodoAux = prioridad;
            for (int i = 0; i < pos_prioridad - 2;i++){
                nodoAux = nodoAux.getSiguiente();
            }
            nueva_prioridad.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nueva_prioridad);
        }
    }

    public boolean esta_vencida(int pos){
        NodoTarea nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            return nodoAux.getEstado().equals("vencida");
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            return nodoAux.getEstado().equals("vencida");
        }
    }

    public boolean esta_completa (int pos){
        NodoTarea nodoAux = prioridad;
        int i = 1;
        if(pos == 1){
            return nodoAux.getEstado().equals("completa");
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            return nodoAux.getEstado().equals("completa");
        }
    }

    public String estado(int pos){
        NodoTarea nodoAux = prioridad;
        int i = 1;
        if(pos == 1){
            return nodoAux.getEstado();
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            return nodoAux.getEstado();
        }
    }

    public void mostrar(){
        //pensar si agregarlo aca o en otro lado
    }
}
