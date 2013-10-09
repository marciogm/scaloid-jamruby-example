package org.scaloid.hello

import org.scaloid.common._
import android.graphics.Color

// the mruby and jamruby related
import org.jamruby.core.Jamruby;
import org.jamruby.mruby.MRuby;
import org.jamruby.mruby.ParserState;
import org.jamruby.mruby.Value;

class HelloScaloid extends SActivity {

  onCreate {
    contentView = new SVerticalLayout {
      style {
        case b: SButton => b.textColor(Color.RED).onClick(toast("Bang!"))
        case t: STextView => t textSize 10.dip
        case v => v.backgroundColor(Color.YELLOW)
      }
	  
	  val jamruby: Jamruby = new Jamruby
	  val parse: ParserState = jamruby.parse("a = 1")		  
	  val ret: Value = jamruby.run(parse)
	  val res = ret.toString(jamruby.state())

      STextView(s"$res")
      SButton(R.string.red)
    } padding 20.dip
  }

}
