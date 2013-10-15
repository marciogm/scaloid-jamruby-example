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
 
object TestScalaObject extends HelloScaloid {
	val TEST_SYMBOL = "*"
	override implicit val ctx = this
	
	// def SetContext(c : Context) = {
	// 	ctx = c
	// }
	// 
	// def GetContext() : Context = {
	// 	ctx
	// }
	
	def testMethod() = {
		toast("marcio")
	}
}
 
class HelloScaloid extends SActivity {
 
  onCreate {	
	// TestScalaObject.SetContext(this)
	
    contentView = new SVerticalLayout {
      style {
        // case b: SButton => b.textColor(Color.RED).onClick(loading())
        case t: STextView => t textSize 10.dip
        case v => v.backgroundColor(Color.YELLOW)
      }  
	  
	  
	  // javap -s -bootclasspath classes.jar -classpath bin/classes org.scaloid.common.SToast
	  
  	  // W/dalvikvm(10144): JNI WARNING: can't call Landroid/widget/Toast;.makeText on instance of Lorg/scaloid/hello/HelloScaloid$$anonfun$2$$anon$1;
  	  // W/dalvikvm(10144):              in Lorg/jamruby/mruby/MRuby;.n_run:(JJLorg/jamruby/mruby/Value;)Lorg/jamruby/mruby/Value; (CallObjectMethodA)
  
  	  // var code = """c = JAVA.find_class("org/scaloid/hello/TestScalaObject")
  	  // 				sm = c.get_static_method("GetContext","()Lorg/scaloid/common/SVerticalLayout;")
  	  // 					o = c.call_static(sm)
  	  // 					to = JAVA.find_class("android/widget/Toast")
  	  // 					im = to.get_static_method("makeText","(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;")
  	  // 					r = to.call(o,im,"Hello, Ruby!",100)
  	  // 
	  
	  // var code = """c = JAVA.find_class("org/scaloid/hello/HelloScaloid")
	  // 				sm = c.get_static_method("testMethod","()Ljava/lang/String;")
	  // 				a = c.call_static(sm)
	  // 					"""
		  
	  // var jamRuby: Jamruby = new Jamruby()
	  // var ps: ParserState = jamRuby.parse(code)
	  // var ret: Value = jamRuby.run(ps)
	  
	  TestScalaObject.testMethod
     
	  // STextView(ret.toString(jamRuby.state()))
      STextView("Me too")
      STextView("I am taller than you") textSize 15.dip // overriding
      SEditText("Yellow input field")
      SButton(R.string.red)
    } padding 20.dip
  }

  
  // def findRubyFile(): Seq[File] = {
  // 	  val finder: PathFinder = ("aa" / "ruby") ** "*.rb"
  // 	  finder.get
  // }
}