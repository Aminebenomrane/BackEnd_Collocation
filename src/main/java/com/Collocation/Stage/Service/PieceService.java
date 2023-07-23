package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.PieceRepository;
import com.Collocation.Stage.Service.interfaces.PieceInteface;
import com.Collocation.Stage.entities.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PieceService implements PieceInteface {

    private final PieceRepository pieceRepository;

    @Autowired
    public PieceService(PieceRepository pieceRepository) {
        this.pieceRepository = pieceRepository;
    }

    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }

    public Piece getPieceById(Integer id) {
        return pieceRepository.findById(id).orElse(null);
    }

    public Piece savePiece(Piece piece) {
        return pieceRepository.save(piece);
    }

    public Piece updatePiece(Integer id, Piece updatedPiece) {
        Piece piece = pieceRepository.findById(id).orElse(null);
        if (piece != null) {
            // Update piece fields with the values from updatedPiece
            piece.setSurface(updatedPiece.getSurface());
            piece.setPrix(updatedPiece.getPrix());
            piece.setDate_Debut(updatedPiece.getDate_Debut());
            piece.setDate_fin(updatedPiece.getDate_fin());
            piece.setDisponibilite(updatedPiece.getDisponibilite());
            piece.setNb_lit(updatedPiece.getNb_lit());
            piece.setLogement(updatedPiece.getLogement());


            return pieceRepository.save(piece);
        }
        return null;
    }

    @Override
    public List<Piece> getAvailablePieces() {
        return pieceRepository.findAvailablePieces();
    }

    public void deletePiece(Integer id) {
        pieceRepository.deleteById(id);
    }
    public Piece updatePieces(Integer id, Piece updatedPiece) {
        Piece piece = pieceRepository.findById(id).orElse(null);
        if (piece != null) {
            // Mettre à jour les champs de la pièce avec les valeurs de updatedPiece
            piece.setNb_lit(updatedPiece.getNb_lit());

            // Vérifier si le nombre de lits est devenu 0
            if (piece.getNb_lit() == 0) {
                piece.setDisponibilite(false);
            }
         else {
            piece.setDisponibilite(true);
        }

            return pieceRepository.save(piece);
        }
        return null;
    }
    }

