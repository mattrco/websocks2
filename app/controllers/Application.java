package controllers;

import play.*;
import play.libs.F.Callback;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render());
  }
  
  public static WebSocket<String> greetWriter() {
      return new WebSocket<String>() {
          
    	  // called when the websocket is established
          public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {

        	  // register a callback for processing instream events
        	  in.onMessage(new Callback<String>() {
                  public void invoke(String event) {
                      Logger.info(event);
                  } 
               });
        	  
        	  // write out a greeting
              out.write("I'm contacting you regarding your recent websocket.");	
          }
      };
  }
  
}