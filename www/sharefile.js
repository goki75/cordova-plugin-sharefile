module.exports = function(fileURI,title,mimetype,success,error){
  if(typeof text !== "string") {
    fileURI = "";
  }
  if(typeof title !== "string") {
    title = "Share";
  }
  if(typeof mimetype !== "string") {
    mimetype = "text/plain";
  }
  cordova.exec(success,error,"Share","share",[fileURI,title,mimetype]);
  return true;
};
