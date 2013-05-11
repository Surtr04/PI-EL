<?php
class myXPath extends DOMXPath{
        const RES = 'RETURNRES';
        public function queryValue($query, $node = null, $default = null){
            $res = $this->query($query, $node);
            if ($default === self::RES) return $res;
            if ($res === false || $res->length < 1){
                $aux = $default;
            }else if ($res->length > 1){
                $aux = array();
                foreach($res as $valor)
                    $aux[] = $valor->textContent;
            }else{
                $aux = $res->item(0)->textContent;
            }
            return $aux;
        }
        public function recQueryToArray($query, $node){
            $arr = array();
            $res = $this->query($query, $node);
            if ($res === false || $res->length <= 0) return false;
            foreach($res as $chave => $valor) {
                $aux = $this->recQueryToArray($query, $valor);
                if ($aux === false)
                    $arr[$valor->localName]['__text'] = $valor->textContent;
                else 
                    $arr[$valor->localName] = $aux;
                if ($valor->hasAttributes()){
                    $arr[$valor->localName]['__atributes'] = array();
                    $length = $valor->attributes->length;
                    for ($i = 0; $i < $length; ++$i) {
                        $atr = $valor->attributes->item($i);
                        $arr[$valor->localName]['__atributes'][$atr->name] = $atr->value;  
                    }
                }
            }
            return $arr;
        }
    }
?>