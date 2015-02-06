// @SOURCE:/Users/fairydream/Documents/CS study/18652-Foundations of Software Engineering/FSE_Backend-master/conf/routes
// @HASH:c092c1005bb60af8adafbff8f552d20443439f9c
// @DATE:Thu Feb 05 14:45:05 PST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:18
// @LINE:15
// @LINE:10
package controllers {

// @LINE:18
class ReverseAssets {


// @LINE:18
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:15
// @LINE:10
class ReverseUserController {


// @LINE:15
def addUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ssnoc/user/signup")
}
                        

// @LINE:10
def test(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "test")
}
                        

}
                          
}
                  


// @LINE:18
// @LINE:15
// @LINE:10
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:18
class ReverseAssets {


// @LINE:18
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:15
// @LINE:10
class ReverseUserController {


// @LINE:15
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.addUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ssnoc/user/signup"})
      }
   """
)
                        

// @LINE:10
def test : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.test",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test"})
      }
   """
)
                        

}
              
}
        


// @LINE:18
// @LINE:15
// @LINE:10
package controllers.ref {


// @LINE:18
class ReverseAssets {


// @LINE:18
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:15
// @LINE:10
class ReverseUserController {


// @LINE:15
def addUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).addUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "addUser", Seq(), "POST", """Users""", _prefix + """ssnoc/user/signup""")
)
                      

// @LINE:10
def test(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).test(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "test", Seq(), "GET", """ Test""", _prefix + """test""")
)
                      

}
                          
}
        
    