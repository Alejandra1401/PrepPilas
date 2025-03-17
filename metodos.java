import java.util.Stack;

import javax.swing.JOptionPane;

public class metodos
{
     public void LlenarPila() 
    {
        Stack<bicicleta> pila = new Stack<>();//Declara variable pila de tipo obj, la pila es una coleccion de objeto
        boolean continuar = true;
        String agregar = "";
        while (continuar) 
        {
            bicicleta o = new bicicleta();
            o.setMarca(JOptionPane.showInputDialog("Ingrese La marca"));
            o.setReferencia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese La referencia")));
            o.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad")));
            o.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio")));
            pila.push(o);//Aqui llevo los datos a la pila 
            agregar = JOptionPane.showInputDialog("Desea agregar mas Registros S/N");
            if (agregar.equalsIgnoreCase("N"))
            {
                continuar = false;
            }
        }
        MostrarPila(pila);
    }
    public void MostrarPila(Stack<bicicleta> pila) 
    {
        for (bicicleta o : pila) //Deshapilando para mostrar(es lo mismo que un for normal)
        {
            System.out.println("Marca: " + o.getMarca());
            System.out.println("Referencia: " + o.getReferencia());
            System.out.println("Cantidad:" + o.getCantidad());
            System.out.println("Precio " + o.getPrecio());
            System.out.println();
        }
    }
    public Stack<bicicleta> AccionesRegistro(Stack<bicicleta> pila, int opt) 
    {
        String dato = "";
        if (opt == 1) 
        {
            dato = JOptionPane.showInputDialog("Ingrese el repuesto a buscar");
        } else if (opt == 2) {
            dato = JOptionPane.showInputDialog("Ingrese el repuesto a modificar");
        } else if(opt ==3) {
            dato = JOptionPane.showInputDialog("Ingrese el repuesto a eliminar");
        }
        else 
        {
            dato = JOptionPane.showInputDialog("Validar cantidad de respuestos");
        }
        for (bicicleta bici : pila) 
        {
            if (bici.getMarca().equalsIgnoreCase(dato)) {
                if (opt == 1) {
                    System.out.println(
                            "el registro se encuentras y es: " + vehiculo.getMarca() + " " + vehiculo.getPrecio());
                } else if (opt == 2) {
                    pila.remove(vehiculo);
                } else {
                    vehiculo.setMarca(JOptionPane.showInputDialog("Ingrese La marca"));

                }
            }
        }

        return pila;
    }
    
}
