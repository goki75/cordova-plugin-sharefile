module.exports = function(fileURI,title,mimetype,success,error){
  if(typeof text !== "string") {
    fileURI = "";
  }
  if(typeof title !== "string") {
    title = "ShareFile";
  }
  if(typeof mimetype !== "string") {
    mimetype = "text/plain";
  }
  cordova.exec(success,error,"ShareFile","sharefile",[fileURI,title,mimetype]);
  return true;
};
