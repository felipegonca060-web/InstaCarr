const express = require("express");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json({limit: "10mb"}));

app.get("/api/health", (_req,res) => {
  res.json({ok:true, app:"InstaCar", version:"1.0.0"});
});

app.get("/api/posts", (_req,res) => {
  res.json({posts:[], message:"Conecte o banco para carregar publicações."});
});

app.post("/api/posts", (req,res) => {
  const {caption} = req.body || {};
  res.status(201).json({id:Date.now().toString(), caption:caption || "", status:"created"});
});

app.listen(process.env.PORT || 3000, () =>
  console.log("InstaCar API running on port " + (process.env.PORT || 3000))
);
