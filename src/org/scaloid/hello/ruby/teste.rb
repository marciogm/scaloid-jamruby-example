c = JAVA.find_class("org/scaloid/common/SToast")
sm = c.get_method("show","()Lorg/scaloid/common/SToast;")
o = c.call_static(sm)
	
# c = JAVA.find_class("org/scaloid/hello/TestScalaObject")
# sm = c.get_static_method("GetContext","()Lorg/scaloid/common/SVerticalLayout;")
# o = c.call_static(sm)