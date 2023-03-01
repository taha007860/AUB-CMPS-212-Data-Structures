public class Rectangle {
        private int x;
        private int y;
        private int width;
        private int height;
        public Rectangle(int x,int y,int width, int height){
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public int getWidth() {
            return width;
        }
        public int getHeight() {
            return height;
        }
        public String toString(){
            return "Rectangle[x="+x+",y="+y+",width="+width+",height="+height+"]";}
    public Rectangle intersection(Rectangle rect) {
            if(     this.getX() + this.getWidth() < rect.getX() ||
                    rect.getX() + rect.getWidth() < this.getX() ||
                    this.getY() + this.getHeight() < rect.getY() ||
                    rect.getY() + rect.getHeight() < this.getY())
                return null;

            int startX = Math.max(this.getX(), rect.getX());
            int endX = Math.min(this.getX() + this.getWidth(),
                    rect.getX() + rect.getWidth());
            int startY = Math.min(this.getY(), rect.getY());
            int endY = Math.max(this.getY() - this.getHeight(),
                    rect.getY() + rect.getHeight());

            return new Rectangle(startX, startY, endX - startX, endY - startY);
        }
        public boolean contains(int x, int y){
            return this.x <= x && x <= this.x + width && this.y <= y &&
                    y <= this.y + height;
        }
         public boolean equals(Object o){
            if(o instanceof Rectangle){
            Rectangle r=(Rectangle) o;
            return x==r.getX()&&y==r.getY()&&height==r.getHeight()&&width==r.getWidth();}
            else{return false;}
    }
    }
