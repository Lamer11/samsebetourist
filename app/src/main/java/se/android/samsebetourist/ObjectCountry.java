package se.android.samsebetourist;

public class ObjectCountry {

        private String name;
        private int image;

        ObjectCountry (String name, int image){
            this.name = name;
            this.image = image;
        }

        public String getName(){ return name; }
        public void setName(){
            this.name = name;
        }

        public int getImage(){ return image; }
        public void setImage(){
            this.image = image;
        }

}
