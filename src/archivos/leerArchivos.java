package archivos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class leerArchivos {
	
	public static void main(String[] args) throws IOException {
JSONParser parser = new JSONParser();
        
        try {
            
            Object obj = parser.parse(new FileReader("data4.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);
            
            JSONArray array = (JSONArray) jsonObject.get("usuario");
            System.out.println("");
            System.out.println("myInteger es de tipo " +  ((Object)jsonObject).getClass().getSimpleName());
            
            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                
                
                
                codigo1(jsonObject1);
                //crear2(jsonObject1);
                //System.out.println("address: " + jsonObject1.get("address"));
                //System.out.println("borough: " + jsonObject1.get("borough"));
                //System.out.println("cuisine: " + jsonObject1.get("cuisine"));
                //System.out.println("grades: " + jsonObject1.get("grades"));
                
                System.out.println("");
            }
            
        } catch(FileNotFoundException e) { }
        catch(IOException e) { }
        catch(ParseException e) { }
		
		
		
		
		
		
		//String json="";
		
		//BufferedReader buffer = new BufferedReader(
			//new InputStreamReader(
				//	new FileInputStream("c:/data2.txt"), "utf-8"
				//)
		//);
		//String linea="";
		//int numLinea=0;
		//while ((linea=buffer.readLine())!=null) {
			
		//	numLinea++;
			//Invocamos el metodo observable
			//codigo1(linea);
			//System.out.println("myInteger es de tipo " +  ((Object)linea).getClass().getSimpleName());
			//System.out.println("este es la cadena"+ linea);
			//codigo2(linea);
			//codigo3(linea);
			//crear1(linea);
			//crear2(linea);
		//}
		
		
	}

	

	private static void crear2(String jsonObject1) {
		String entrada="Manhattan";
		// TODO Auto-generated method stub
		Observable<String> source = Observable.create(emitter -> {
			try {
				emitter.onNext(jsonObject1);	
				emitter.onComplete();
			} catch (Throwable e) {
				emitter.onError(e);
			}
		});
		Observable<Integer> lengths = source.map(String::length);
		Observable<Integer> filtered = lengths.filter(i -> i >= 780);
		filtered.subscribe(s -> System.out.println("RECEIVED: " + s));


	}

	private static void crear1(String linea) {
		// TODO Auto-generated method stub
		Observable<String> source = Observable. create(emitter -> {
			 emitter. onNext(linea);
			 
			 
			 emitter. onComplete();
			 });
			 source. subscribe(s -> System. out. println("RECEIVED: " + s));
		
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	private static void codigo3(String linea) {
		// TODO Auto-generated method stub
		Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);
		secondIntervals.subscribe(s -> System.out.println(s));
		/*
		 * Hold main thread for 5 seconds so Observable above has chance to fire
		 */
		sleep(5000);
	}

	

	private static void codigo2(String linea) {
		Observable<String> myStrings =  Observable.just(linea);
		//transforma los datos y lo entrega al usuario
		 myStrings.map(s -> s.length()).subscribe(s -> System.out.println(s));
		 }

		

	private static void codigo1(JSONObject jsonObject1) {
		String entrada="Manhattan";
		//System.out.println("RECEIVED: " + jsonObject1);
		Observable<Object> myStrings = Observable. just(jsonObject1);
		//Solo entrega los datos, tal como le llega
		//myStrings.subscribe(s -> System.out.println("RECEIVED: " + s));
		

		
		
		Observable<Object> filtered = myStrings.filter(i -> jsonObject1.get("borough").equals(entrada) );
		filtered.subscribe(s -> System.out.println("RECEIVED: " + s));
		
		 
		

	}
	

}
