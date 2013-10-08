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
	  
	  val jamruby = new Jamruby
	  val parse = jamruby.parse("a = 1")
	  val str_ary = new java.lang.String
	  val ret = jamruby.run(parse)

      STextView("I am 10 dip tall")
      STextView("Me too")
      STextView("I am taller than you") textSize 15.dip // overriding
      SEditText("Yellow input field")
      SButton(R.string.red)
    } padding 20.dip
  }

}
