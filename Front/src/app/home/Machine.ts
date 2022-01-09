import Konva from "Konva";
import Arrow from "./arrow";
import Factory from "./Factory";

class Machine implements Factory{
    layer: Konva.Layer
    arrows: Arrow[] = []
    machineGroup: Konva.Group
    ID!:string 
    inn: string[] =[]
    out: string[]= []
    color = 'red'

    constructor(layer: Konva.Layer, shift:number, m:number){
        this.layer = layer  
        var shp = new Konva.Group({        
            x: 150+shift, 
            y: 150+shift, 
            width: 130,
            height: 25,
            rotation: 0, 
            draggable: true,
            name:"Machine",
            id: "m"+m

          })

          shp.add(new Konva.Circle({
            
            radius:75/2,
            stroke: "rgb(0,0,0)",
            strokeWidth: 3,
            fill: this.color,
            name:"Machine",
    
        }));
          shp.add(new Konva.Text({
            x:-25,
            y:-20,
            text:"M"+m,
            fontSize: 30,
            fontStyle:('bold'),
            fontFamily: 'Calibri',
            fill: '#000',
            padding: 5,
            align: 'center',
            name:"Machine"
          }));
          shp.add(new Konva.Rect({
            x:0,
            y:75/2,
            width:0,
            height: 0,
            name:"1"

        }))
        shp.add(new Konva.Rect({
            x:0,
            y:-75/2,
            width:0,
            height: 0,
            name:"2"

        }))
        shp.add(new Konva.Rect({
            x:75/2,
            y:0,
            width:0,
            height: 0,
            name:"3"

        }))
        shp.add(new Konva.Rect({
            x:-75/2,
            y:0,
            width:0,
            height: 0,
            name:"4"

        }))

          this.ID = "m"+m
          this.machineGroup = shp
          this.layer.add(this.machineGroup)
          this.layer.draw();
          return this
     
    }



}
export default Machine;
