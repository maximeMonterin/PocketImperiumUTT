package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.SkinManager;

public class Sector {
	
	
	/* -_-_-_-_-_-_-_- ATTRIBUTS -_-_-_-_-_-_-_- */
	
	
	private List<List<Square>> hexlist = new ArrayList<List<Square>>();
	private HashMap<Integer, String> sectorSkin = new HashMap<Integer, String>();
	private int[][] sectorBuilder;
	private int sectorLineKey = 1;
	private LinePosition linePosition;
	
	
	/* -_-_-_-_-_-_-_- CONSTRUCTOR -_-_-_-_-_-_-_- */
	
	
	public Sector(int[][] sectorBuilder) {
		this.setSectorBuilder(sectorBuilder);
		
		for(int i = 0; i < this.getSectorBuilder().length; ++i) {
			
			List<Square> tempList = new ArrayList<Square>();
			
			for(int y = 0; y < this.getSectorBuilder()[i].length; ++y) {
				
				Square hexa = new Square();
				tempList.add(hexa);
			}
			
			this.getHexlist().add(tempList);
		}
		
		
	}
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	
	public void skinSectorBuilder() {
		
		for(int i = 0; i < this.getHexlistTest().size(); ++i) {
			sectorLineStringBuilder(this.getHexlistTest().get(i));
		} 
			
	}
	
	
	public void sectorLineStringBuilder(List<Square> param) {
		
		String line = "";
		int skinKey = 1;
		//int sizeSkin = 0;
		
		while(skinKey <= 5) {
			
			for(int i = 0; i < param.size(); ++i) {
				
				//sizeSkin = param.get(i).getSkin().size();
				
				if(param.get(i).getSkin().get(skinKey) == null) {
					line += "";
				} else {
					line += param.get(i).getSkin().get(skinKey);
				}
			}
			
			/*if(skinKey != sizeSkin + 1) {
				line += '\r';
			}*/

			if(!line.isEmpty()) {
				this.sectorSkin.put(this.sectorLineKey, line);
				++this.sectorLineKey;
			}

			line = "";
			++skinKey;
			
		}

	}
	
	
	public void addSkinToHex() {
		
		SkinManager skinManager = new SkinManager();
		
		for(int i = 0; i < this.getSectorBuilder().length; ++i) {
			for(int j = 0; j < this.getSectorBuilder()[i].length; ++j) {
				
				switch(this.getSectorBuilder()[i][j]) {
					case 1:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinOne());
						break;
					case 2:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinTwo());
						break;
					case 3:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinThree());
						break;
					case 4:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinFour());
						break;
					case 5:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinFive());
						break;
					case 6:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinSix());
						break;
					case 7:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinSeven());
						break;
					case 8:
						this.getHexlistTest().get(i).get(j).setSkin(skinManager.getSkinEight());
						break;
				}
				
			}
		}
	}
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */
	

	public LinePosition getLinePosition() {
		return linePosition;
	}

	public void setLinePosition(LinePosition linePosition) {
		this.linePosition = linePosition;
	}

	public int[][] getSectorBuilder() {
		return sectorBuilder;
	}

	public void setSectorBuilder(int[][] sectorBuilder) {
		this.sectorBuilder = sectorBuilder;
	}


	public List<List<Square>> getHexlistTest() {
		return hexlist;
	}


	public void setHexlistTest(List<List<Square>> hexlistTest) {
		this.hexlist = hexlistTest;
	}


	public List<List<Square>> getHexlist() {
		return hexlist;
	}


	public void setHexlist(List<List<Square>> hexlist) {
		this.hexlist = hexlist;
	}


	public HashMap<Integer, String> getSectorSkin() {
		return sectorSkin;
	}


	public void setSectorSkin(HashMap<Integer, String> sectorSkin) {
		this.sectorSkin = sectorSkin;
	}
	
	
	
}
