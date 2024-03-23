
class Node{
  constructor(){
    this.isEnd = false;
    this.nodes = [... Array(26)].map(item=>null);
  }

  ascii(ch){
    return ch.charCodeAt(0);
  }

  index(ch){
    const id =  this.ascii(ch.toLowerCase()) - this.ascii('a');
    return id;
  }

  contains(ch){
    return this.nodes[this.index(ch)] != null;
  }

  put(ch,node){
    return this.nodes[this.index(ch)] = node;
  }

  getNext(ch){
    return this.nodes[this.index(ch)];
  }


  setEnd(){
    this.isEnd = true;
  }
}


