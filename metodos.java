import java.util.Stack;

import javax.swing.JOptionPane;

public class metodos
{
    public Stack<bicicleta> LlenarPila() 
    {
        Stack<bicicleta> pila = new Stack<>();//Declara variable pila de tipo obj, la pila es una coleccion de objeto
        boolean continuar = true;
        String agregar = "";
        String ingreso;
        while (continuar) 
        {
            bicicleta o = new bicicleta();
            o.setMarca(JOptionPane.showInputDialog("Ingrese la marca del repuesto"));
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese la referencia del repuesto");
            while (!ingreso.matches("\\d+")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese la referencia valida");
            }
            o.setReferencia(Integer.parseInt(ingreso));
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese la cantidad de repuestos");
            while (!ingreso.matches("\\d+")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese cantidad valida");
            }
            o.setCantidad(Integer.parseInt(ingreso));
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese el precio del repuesto");
            while (!ingreso.matches("\\d+(\\.\\d+)?")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese precio valido");
            }
            o.setPrecio(Double.parseDouble(ingreso));
            pila.push(o);//Aqui llevo los datos a la pila 
            JOptionPane.showMessageDialog(null, "Repuesto agregado con exito");
            agregar = JOptionPane.showInputDialog("Desea agregar mas Registros S/N");
            if (agregar.equalsIgnoreCase("N"))
            {
                continuar = false;
            }
        }
        return pila;
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
    /*public Stack<bicicleta> AccionesRegistro(Stack<bicicleta> pila, int opt) 
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
    }*/
    public void buscarRep (Stack<bicicleta> pila)
    {
        int refABusc;
        refABusc = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la referencia que desea buscar")));
        for (bicicleta bici : pila)
        {
            if(bici.getReferencia() == refABusc) // == porque referencia es una entero too double 
            {
                JOptionPane.showMessageDialog(null, "Datos del repuesto buscado\n"+
                         "Marca:" + bici.getMarca()+"\n" + "Referencia: " + bici.getReferencia() +"\n" +
                         "Cantidad: " + bici.getCantidad() + "\n" + "Precio: " + bici.getPrecio() ); 
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Repuesto no encontrado");
    }
    public void modifRepuesto(Stack<bicicleta> pila)
    {
        while (pila.empty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
        }
        int refAMod = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la referencia del repuesto que desea modificar")));
        for(bicicleta bici : pila)
        {
            if(bici.getReferencia() == refAMod)
            {
                int opc;
                do 
                {
                    opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción\n" + "1: Marca\n" + "2: Referencia\n" +
                                                                     "3: Cantidad\n" + "4:Precio\n"));
                    switch (opc) 
                    {
                        case 1:
                            String newmarca = JOptionPane.showInputDialog("Ingrese nueva marca");
                            bici.setMarca(newmarca);
                            JOptionPane.showMessageDialog(null, "Marca modificada con exito");
                        break;
                        case 2:
                            int newreferen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva referencia"));
                            bici.setReferencia(newreferen);
                            JOptionPane.showMessageDialog(null, "Referencia modificada con exito");
                        break;
                        case 3:
                            int newcant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad"));
                            bici.setCantidad(newcant);
                            JOptionPane.showMessageDialog(null, "Cantidad modificada con exito");
                        break;
                        case 4:
                            double newprecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
                            bici.setPrecio(newprecio);
                            JOptionPane.showMessageDialog(null, "Precio modificada con exito");
                        break;
                        default:
                            JOptionPane.showMessageDialog(null, "Modificación fallida");
                        break;
                    }
                }while(opc > 3 || opc < 1);
            } else
            {
                JOptionPane.showMessageDialog(null, "Referencia de repuesto no encontrada");
            }
        }
    }
    
}
