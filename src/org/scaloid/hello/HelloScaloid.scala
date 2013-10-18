package org.scaloid.hello
 
import org.scaloid.common._
import android.graphics.Color
import java.io.File
import java.io.FileFilter
import android.content.Context
import android.app._
import android.content._
import android.os._
import android.view._
 
import org.jamruby.core.Jamruby
import org.jamruby.mruby.MRuby
import org.jamruby.mruby.ParserState
import org.jamruby.mruby.Value
 
object CallUIMethodsFromClass extends HelloScaloid {
	// val TEST_SYMBOL = "*"
	// override def basis = this
	// override implicit val ctx = this

	// def SetContext(c : Context) = {
	// 	ctx = c
	// }
	// 
	// def GetContext() : Context = {
	// 	ctx
	// }

	def callToast() : Unit = {
		showToast()
	}
}

 
class HelloScaloid extends SActivity {
	 
  onCreate {
    contentView = new SVerticalLayout {
      style {
        case t: STextView => t textSize 10.dip
        case v => v.backgroundColor(Color.YELLOW)
      }  
	  
	  var code = """c = JAVA.find_class("org/scaloid/hello/CallUIMethodsFromClass")
	  				sm = c.get_static_method("callToast","()V")
	  				"""
	  		  
	  var jamRuby: Jamruby = new Jamruby()
	  var ps: ParserState = jamRuby.parse(code)
	  var ret: Value = jamRuby.run(ps)
	  //      
	  
	  STextView(ret.toString(jamRuby.state()))
      STextView("Me too")
      STextView("I am taller than you") textSize 15.dip // overriding
      SEditText("Yellow input field")
      SButton(R.string.red)
    } padding 20.dip
  }
  
  def showToast() : Unit = {
	  toast("teste")
  }

}