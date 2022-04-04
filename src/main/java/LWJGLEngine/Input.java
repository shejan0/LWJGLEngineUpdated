package LWJGLEngine;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import java.util.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
public class Input {
	//this is the function that input code is meant to go to
	//eventually this will be setup that it can be accessible from GObject
	//every operation gets set to a dictionary (key = button, value = mods)
public void keyboard(long window, int key, int scancode, int action, int mods) {
	if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
		glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
}
public void mousebutton(long window,int button, int action, int mods){
	if (button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS){
		Main.engine.renderer.setBackColor();
	}
}
}
