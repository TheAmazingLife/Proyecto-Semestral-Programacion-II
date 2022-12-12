
package geometricas;

import java.awt.Point;
import java.awt.Polygon;


public class RellenaConPuntos {
    public synchronized static void nuevaLinea(Point a, Point b, Polygon p){
        nuevaLinea(a.x,a.y,b.x,b.y,p);
    }
    
    public synchronized static void nuevaLinea(int nx1,int ny1,int nx2,int ny2, Polygon p){
           int npy=0;
           if(nx1==nx2&&ny1==ny2)return;
           if(ny1>ny2)npy=ny1-ny2-1;else npy=ny2-ny1-1;            
            int npx=0;
           if(nx1>nx2)npx=nx1-nx2-1; else npx=nx2-nx1-1;
           int np;
           if(npy>npx)np=npy;else np=npx;
           if(np<1)return;
           if(npy>npx){
               if(npy>0){creaLineaY(nx1,ny1,nx2,ny2,np,p);return;}
               else return;
           } else {
               if(npx>0){creaLineaX(nx1,ny1,nx2,ny2,np,p);return;}
               else return;
           }
        }
        private static void creaLineaX(int nx1,int ny1,int nx2,int ny2, int np, Polygon p){
	   double m = (((double)ny2-(double)ny1))/(((double)nx2-(double)nx1));
	   String borrar = Double.toString(m);
	   if(borrar.endsWith("-Infinity")||borrar.endsWith("Infinity")){
		for (int i = 1; i< np+1;i++){
                    if(nx1<nx2)p.addPoint(nx1,ny1+i);
                    else p.addPoint(nx1,ny1-i);
                }
           } else {
		double b = (double)ny1-m*(double)nx1;
		for (int i = 1; i < np+1;i++){
                   int yi;
		   if(nx1<nx2){
                       yi= (int)((double)(nx1+i)*m+(double)b);
                       p.addPoint(nx1+i,yi);
                   } else {
                       yi= (int)((double)(nx1-i)*m+(double)b);
                       p.addPoint(nx1-i,yi);
                   }
	       }
           }
       } 
       private static void creaLineaY(int nx1,int ny1,int nx2,int ny2, int np, Polygon p){
	   double m = (((double)ny2-(double)ny1))/(((double)nx2-(double)nx1));
	   String borrar = Double.toString(m);
	   if(borrar.endsWith("-Infinity")||borrar.endsWith("Infinity")){
		for (int i = 1; i<np+1;i++){
                    if(ny1<ny2)p.addPoint(nx1,ny1+i);
                    else p.addPoint(nx1,ny1-i);
                }
	   } else {
		double b = (double)ny1-m*(double)nx1;
		for (int i = 1; i <np+1;i++){
                    int xi;
                 if(ny1<ny2){                                                 
                     xi= (int)(((double)(ny1+i)-(double)b)/m);
                     p.addPoint(xi,ny1+i);
                 } else {
                     xi= (int)(((double)(ny1-i)-(double)b)/m);
                     p.addPoint(xi,ny1-i);
                 }
	        }
           }
       } 
    
}
