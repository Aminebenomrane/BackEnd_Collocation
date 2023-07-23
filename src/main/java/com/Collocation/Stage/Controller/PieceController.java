package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.PieceService;
import com.Collocation.Stage.entities.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pieces")
public class PieceController {

    private final PieceService pieceService;

    @Autowired
    public PieceController(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @GetMapping
    public List<Piece> getAllPieces() {
        return pieceService.getAllPieces();
    }


    @GetMapping("/{id}")
    public Piece getPieceById(@PathVariable Integer id) {
        return pieceService.getPieceById(id);
    }

    @PostMapping
    public Piece createPiece(@RequestBody Piece piece) {
        return pieceService.savePiece(piece);
    }

    @PutMapping("/{id}")
    public Piece updatePiece(@PathVariable Integer id, @RequestBody Piece updatedPiece) {
        return pieceService.updatePiece(id, updatedPiece);
    }
    @GetMapping("/disponibles")
    public ResponseEntity<List<Piece>> getAvailablePieces() {
        List<Piece> pieces = pieceService.getAvailablePieces();
        return new ResponseEntity<>(pieces, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePiece(@PathVariable Integer id) {
        pieceService.deletePiece(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Piece> updatePieces(@PathVariable("id") Integer id, @RequestBody Piece updatedPiece) {
        Piece piece = pieceService.updatePiece(id, updatedPiece);
        if (piece != null) {
            return new ResponseEntity<>(piece, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
