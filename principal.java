import java.util.Stack;

import javax.swing.JOptionPane;
public class principal 
{
    public static void main(String[] args) 
    {
        metodos m = new metodos();
        Stack<bicicleta> pila = new Stack<>();
        int opc;
        String menu = "           MENÚ \n" + 
                        "1: Ingresar repuesto\n" + 
                        "2: Buscar repuesto\n"+
                        "3: Modificar repuesto\n" +
                        "4: Eliminar repuesto\n" +
                        "5: Vender repuesto\n" +
                        "6: SALIR\n";
        do
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción " + menu));
            if(opc > 6 || opc < 1)
            {
                JOptionPane.showMessageDialog( null, "Opcion no valida, reintente");//Recursividad para que no se salga
            }
            switch (opc) 
            {
                case 1:
                   pila = m.LlenarPila();
                    m.MostrarPila(pila);
                    break;
                case 2:
                    m.buscarRep(pila);
                    break;
                case 3:
                    m.modifRepuesto(pila);
                    break;
                case 4:
                    pila = m.elimiRep(pila);
                    m.MostrarPila(pila);
                    break;
                case 5:
                    m.venderRep(pila);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "BYE");
                    break;
            }

        }while(opc !=6);   
    }
    
}
