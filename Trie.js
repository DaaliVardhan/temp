class Trie{
  constructor(){
    this.root = new Node();
  }

  insert(word){
    let node = this.root;
    for(let char of word){
      if(!node.contains(char)){
        node.put(char,new Node());
      }
      node = node.getNext(char);
    }
    node.setEnd();
  }

  util(path,node,words){
    if(node.isEnd){
      words.push(path);
    }
    for(let i=0;i<26;i++){
      if(node.nodes[i]!=null)
        this.util(path+String.fromCharCode('a'.charCodeAt(0)+i),node.nodes[i],words);
    }
  }

  search(word){
    let node = this.root;
    let path = "";
    const words = []
    for(let char of word){
      if(!node.contains(char) && path!=''){
        this.util(path,node,words);
      } else {
        path += char;
        node = node.getNext(char);
      }
    }
    if(path!="")
      this.util(path,node,words);
    return words;
  }
}