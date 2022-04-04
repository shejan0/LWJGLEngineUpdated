package LWJGLEngine;
import org.lwjgl.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import org.lwjgl.assimp.*;



import java.nio.*;
import java.util.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
public class Model {
	AIScene scene;
	ArrayList<AIMesh> meshes;
	ArrayList<AIMaterial> materials;
	ArrayList<AILight> lights;
	public Model(String resourcePath) throws Exception {
		scene =Assimp.aiImportFile(resourcePath, Assimp.aiProcess_JoinIdenticalVertices | Assimp.aiProcess_Triangulate | Assimp.aiProcess_FixInfacingNormals|Assimp.aiProcess_CalcTangentSpace|Assimp.aiProcess_SortByPType);
		meshes=new ArrayList<AIMesh>();
		materials=new ArrayList<AIMaterial>();
		lights=new ArrayList<AILight>();
		if (scene == null) {
	        throw new Exception("Error loading model: "+resourcePath);
	    }
		int numMeshes=scene.mNumMeshes();
		PointerBuffer meshesBuffer = scene.mMeshes();
		//meshesBuffer.clear();
		for(int n=0;n<numMeshes;n++) {
			AIMesh mesh = AIMesh.create(meshesBuffer.get(n));
			meshes.add(mesh);
		}
		//meshesBuffer.free();
		int numMaterials=scene.mNumMaterials();
		PointerBuffer materialsBuffer = scene.mMaterials();
		for(int n=0;n<numMaterials;n++) {
			AIMaterial material = AIMaterial.create(materialsBuffer.get(n));
			materials.add(material);
		}
		int numLights=scene.mNumLights();
		PointerBuffer lightsBuffer = scene.mLights();
		for(int n=0;n<numLights;n++) {
			AILight light= AILight.create(lightsBuffer.get(n));
			lights.add(light);
		}
		
	}
	/*
	 * public static Mesh[] load(String resourcePath, String texturesDir) throws Exception {
	    return load(resourcePath, texturesDir, Assimp.aiProcess_JoinIdenticalVertices | Assimp.aiProcess_Triangulate | Assimp.aiProcess_FixInfacingNormals);
	
	}

	public static Mesh[] load(String resourcePath, String texturesDir, int flags) throws Exception {
	    AIScene scene = Assimp.aiImportFile(resourcePath, flags);
	    if (scene == null) {
	        throw new Exception("Error loading model: "+resourcePath);
	    }
	    int numMaterials =scene.mNumMaterials();
	    PointerBuffer sceneMaterials = scene.mMaterials();
	    //finish load function from https://lwjglgamedev.gitbooks.io/3d-game-development-with-lwjgl/content/chapter27/chapter27.html
	    ArrayList<AIMaterial> materials = new ArrayList<AIMaterial>();
	    for(int n=0;n<numMaterials;n++) {
	    	AIMaterial aimaterial = AIMaterial.create(sceneMaterials.get(n));
	    	processMaterial(aimaterial, materials, texturesDir);
	    	
	    }
	    int numMeshes = scene.mNumMeshes();
	    PointerBuffer sceneMeshes = scene.mMeshes();
	    AIMesh[] meshes = new AIMesh[numMeshes];
	    for(int n=0;n<numMeshes;n++) {
	    	AIMesh aiMesh = AIMesh.create(aiMeshes.get(i));
	    	Mesh
	    }
	}
	private static void processMaterial(AIMaterial aiMaterial, List<Material> materials, String texturesDir) throws Exception {
	    AIColor4D colour = AIColor4D.create();

	    AIString path = AIString.calloc();
	    Assimp.aiGetMaterialTexture(aiMaterial, Assimp.aiTextureType_DIFFUSE, 0, path, (IntBuffer) null, null, null, null, null, null);
	    String textPath = path.dataString();
	    AITexture texture = null;
	    if (textPath != null && textPath.length() > 0) {
	         textCache = TextureCache.getInstance();
	        texture = textCache.getTexture(texturesDir + "/" + textPath);
	    }

	    Vector4f ambient = AIMaterial.DEFAULT_COLOUR;
	    int result = aiGetMaterialColor(aiMaterial, AI_MATKEY_COLOR_AMBIENT, aiTextureType_NONE, 0, colour);
	    if (result == 0) {
	        ambient = new Vector4f(colour.r(), colour.g(), colour.b(), colour.a());
	    }

	    Vector4f diffuse = AIMaterial.DEFAULT_COLOUR;
	    result = aiGetMaterialColor(aiMaterial, AI_MATKEY_COLOR_DIFFUSE, aiTextureType_NONE, 0, colour);
	    if (result == 0) {
	        diffuse = new Vector4f(colour.r(), colour.g(), colour.b(), colour.a());
	    }

	    Vector4f specular = AIMaterial.DEFAULT_COLOUR;
	    result = aiGetMaterialColor(aiMaterial, AI_MATKEY_COLOR_SPECULAR, aiTextureType_NONE, 0, colour);
	    if (result == 0) {
	        specular = new Vector4f(colour.r(), colour.g(), colour.b(), colour.a());
	    }

	    AIMaterial material = new AIMaterial(ambient, diffuse, specular, 1.0f);
	    material.setTexture(texture);
	    materials.add(material);
	}
	 */
}
