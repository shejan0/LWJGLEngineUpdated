package LWJGLEngine;

import org.lwjgl.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import org.lwjgl.assimp.*;
import org.joml.*;


import java.nio.*;
import java.util.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
public class GObject {
	//@Nullable
	Model model; 
	Vector3f position,scale;
	Quaternionf rotation;
	String name;
	ArrayList<GObject> children;
	public GObject() { //construct Empty
		this("GObject "+Engine.generateRandString(10),null,new Vector3f(0,0,0),new Vector3f(1,1,1),new Quaternionf());
		
	}
	public GObject(String nam) { //construct empty with title
		this(nam,null,new Vector3f(0,0,0),new Vector3f(1,1,1),new Quaternionf());
		
	}
	public GObject(Model mod, Vector3f pos,Vector3f scal,Quaternionf rot) {
		this("GObject "+Engine.generateRandString(10),mod,pos,scal,rot);
	}
	public GObject(String nam,Model mod,Vector3f pos,Vector3f scal,Quaternionf rot) {
		name=nam;
		model=mod;
		position=pos;
		scale=scal;
		rotation=rot;
		Launch();
	}
	//need to use Threading in order to run FrameUpdate scripts 
	public void Launch() {
		//these are to be extended by the script class
	}
	
	public void FrameUpdate() {
		//these are to be extended by the script class
	}
}
